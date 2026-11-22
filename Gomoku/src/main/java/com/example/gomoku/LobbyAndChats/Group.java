package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.Match.HumanMatch;
import com.example.gomoku.Match.SpectateManager;
import com.example.gomoku.UsersAuthAndStatistics.RatingCalculator;
import com.example.gomoku.UsersAuthAndStatistics.User;

import java.nio.file.AccessDeniedException;
import java.time.Duration;
import java.util.*;
import java.util.List;

public class Group {
    private Map<User, ColorType> host;

    private Map<User, ColorType> guest;

    private boolean isRated;

    private Duration timePerRound;

    private GroupChat groupChat;

    public Group(User host, User guest) {
        this.host = new HashMap<>();
        this.guest = new HashMap<>();

        this.host.put(host, null);
        this.guest.put(guest, null);

        this.timePerRound = Duration.ofMinutes(3);

        this.groupChat = new GroupChat();
        groupChat.addMember(host);
        groupChat.addMember(guest);
    }

    public synchronized void passHost() {
        if (guest.isEmpty()){
            throw new IllegalStateException("Brak gościa, któremu można przekazać rolę hosta");
        }

        Map<User, ColorType> temp = host;
        host = guest;
        guest = temp;
    }

    public synchronized HumanMatch startHostGuestGame(User hostUser,  SpectateManager sM, RatingCalculator rC) throws IllegalAccessException {
        if (!isFull()){
            throw new IllegalStateException("Grupa nie jest pełna");
        }

        if (!host.containsKey(hostUser)) {
            throw new IllegalAccessException("Tylko host może rozpocząć grę");
        }

        for (Map.Entry<User, ColorType> entry : host.entrySet()) {
            if (!entry.getKey().equals(hostUser)) {
                throw new IllegalAccessException("Nie jesteś w tej grupie");
            }
        }

        randomiseIfColorNotPicked();

        ColorType hostColor = host.get(hostUser);

        User guestUser = guest.keySet().iterator().next();
        ColorType guestColor = null;

        for (Map.Entry<User, ColorType> entry : guest.entrySet()) {
            if (!entry.getKey().equals(guestUser)) {
                throw new IllegalAccessException("Nie jesteś w tej grupie");
            }

            guestColor = entry.getValue();
        }

        return new HumanMatch(timePerRound, isRated, hostUser, guestUser, hostColor, guestColor, sM, rC);
    }

    public synchronized void leave(User user) {
        if (host.containsKey(user)) {
            if (!guest.isEmpty()){
                passHost();
                guest.clear();
            }
            else {
                host.clear();
            }
            groupChat.removeMember(user);
        }
        else if (guest.containsKey(user)) {
            guest.clear();
            groupChat.removeMember(user);
        }
    }

    public synchronized void chooseColor(User user, ColorType color) throws IllegalAccessException {
        if (color == null){
            throw new IllegalArgumentException("Kolor nie jest ustawiony");
        }

        if (host.containsKey(user)) {
            if (color == ColorType.White){
                host.put(user, color);
                guest.replaceAll((k, v) -> ColorType.Black);
            }
            else if (color == ColorType.Black){
                host.put(user, color);
                guest.replaceAll((k, v) -> ColorType.White);
            }
        }
        else if (guest.containsKey(user)) {
            for (Map.Entry<User, ColorType> entry : host.entrySet()) {
                if (entry.getValue() == color && color == ColorType.Black) {
                    guest.put(user, ColorType.White);
                }
                else if (entry.getValue() == color && color == ColorType.White) {
                    guest.put(user, ColorType.Black);
                }
                else if (entry.getValue() != color){
                    guest.put(user, color);
                }
            }
        }
        else {
            throw new IllegalAccessException("Nie jesteś w tej grupie");
        }
    }

    public synchronized List<ColorType> checkAvailableColors() {
        for (Map.Entry<User, ColorType> entry : host.entrySet()) {
            if (entry.getValue() == ColorType.Black) {
                return Collections.singletonList(ColorType.White);
            }
            else if (entry.getValue() == ColorType.White) {
                return Collections.singletonList(ColorType.Black);
            }

        }

        return List.of(ColorType.Black, ColorType.White);
    }

    public synchronized void dropColor(User user) throws IllegalAccessException {
        if (!host.containsKey(user) && !guest.containsKey(user)) {
            throw new IllegalAccessException("Nie masz uprawnień do tej grupy");
        }

        if (host.containsKey(user)) {
            host.put(user, null);
        }
        else {
            guest.put(user, null);
        }

    }

    public synchronized void randomiseIfColorNotPicked() {
        ColorType hostColor = null;
        ColorType guestColor = null;

        for (Map.Entry<User, ColorType> entry : host.entrySet()) {
            hostColor = entry.getValue();
        }

        for (Map.Entry<User, ColorType> entry : guest.entrySet()) {
            guestColor = entry.getValue();
        }

        if (hostColor != null && guestColor != null) {
            return;
        }

        if (hostColor == null && guestColor == null) {
            int randomNum = (int) (Math.random() * 2);

            if (randomNum == 0) {
                hostColor = ColorType.Black;
            }
            else {
                hostColor = ColorType.White;
            }
        }
        else if (hostColor == null) {
            if (guestColor == ColorType.Black) {
                hostColor = ColorType.White;
            }
            else {
                hostColor = ColorType.Black;
            }
        }

        if (hostColor == ColorType.Black) {
            guestColor = ColorType.White;
        }
        else {
            guestColor = ColorType.Black;
        }

        for (Map.Entry<User, ColorType> entry : host.entrySet()) {
            host.put(entry.getKey(), hostColor);
        }

        for (Map.Entry<User, ColorType> entry : guest.entrySet()) {
            guest.put(entry.getKey(), guestColor);
        }
    }

    public synchronized boolean isFull() {
        if (!host.isEmpty() && !guest.isEmpty()) {
            return true;
        }

        return false;
    }

    public synchronized void disband() {
        host.clear();
        guest.clear();
        groupChat.close();
    }

    public synchronized void setTimePerRound(User host, Duration timePerRound) throws IllegalAccessException {
        if (!this.host.containsKey(host)) {
            throw new IllegalAccessException("Nie jesteś hostem");
        }

        if (timePerRound == null) {
            throw new IllegalArgumentException("Musisz wprowadzić czas");
        }

        if (timePerRound.compareTo(Duration.ofMinutes(15)) > 0){
            throw new IllegalArgumentException("Czas na wykonanie ruchu nie może być dluższy niż 15 minut");
        }

        if (timePerRound.isZero()){
            throw new IllegalArgumentException("Czas na wykonanie ruchu nie może byc zerowy");
        }

        if (timePerRound.compareTo(Duration.ofSeconds(0)) < 0){
            throw new IllegalArgumentException("Czas na wykonanie ruchu nie może być ujemny");
        }

        this.timePerRound = timePerRound;
    }

    public synchronized void setRated(User host, boolean isRated) throws IllegalAccessException {
        if (!this.host.containsKey(host)) {
            throw new IllegalAccessException("Nie jesteś hostem");
        }

        this.isRated = isRated;
    }

    public synchronized User getHostUser(){
        if (!host.isEmpty()){
            return host.keySet().iterator().next();
        }

        return null;
    }

    public synchronized ColorType getHostColor(){
        if (!host.isEmpty()){
            return host.values().iterator().next();
        }

        return null;
    }

    public synchronized User getGuestUser(){
        if (!guest.isEmpty()){
            return guest.keySet().iterator().next();
        }

        return null;
    }

    public synchronized ColorType getGuestColor(){
        if (!guest.isEmpty()){
            return guest.values().iterator().next();
        }

        return null;
    }

    public synchronized boolean isRated() {
        return isRated;
    }

    public synchronized Duration getTimePerRound() {
        return timePerRound;
    }

    public GroupChat getGroupChat() {
        return groupChat;
    }

}