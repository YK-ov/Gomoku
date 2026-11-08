package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.Match.HumanMatch;
import com.example.gomoku.Match.SpectateManager;
import com.example.gomoku.UsersAuthAndStatistics.User;

import java.time.Duration;
import java.util.*;

/**
 * 
 */
public class Group {
    private Map<User, ColorType> host;

    /**
     * 
     */
    private Map<User, ColorType> guest;

    /**
     * 
     */
    private boolean isRated;

    /**
     * 
     */
    private Duration timePerRound;

    /**
     * 
     */
    private GroupChat groupChat;


    /**
     * @param host 
     * @param guest
     */
    public Group(User host, User guest) {
        this.host = new HashMap<>();
        this.guest = new HashMap<>();

        this.host.put(host, null);
        this.guest.put(guest, null);

        this.groupChat = new GroupChat();
    }

    /**
     * @return
     */
    public void passHost() {
        // TODO implement here

    }

    /**
     * @param timer 
     * @param isRated 
     * @param firstUser 
     * @param secondUser 
     * @param firstColor 
     * @param secondColor 
     * @param sM 
     * @return
     */
    public HumanMatch startHostGuestGame(Duration timer, boolean isRated, User firstUser, User secondUser, ColorType firstColor, ColorType secondColor, SpectateManager sM) {
        // TODO implement here
        return null;
    }

    /**
     * @param user 
     * @return
     */
    public void leave(User user) {
        // TODO implement here

    }

    /**
     * @param user 
     * @param color 
     * @return
     */
    public void chooseColor(User user, ColorType color) {
        // TODO implement here

    }

    /**
     * @return
     */
    public List<ColorType> checkAvailableColors() {
        // TODO implement here
        return null;
    }

    /**
     * @param user 
     * @return
     */
    public void dropColor(User user) {
        // TODO implement here

    }

    /**
     * @return
     */
    public void randomiseIfColorNotPicked() {
        // TODO implement here

    }

    /**
     * @return
     */
    public boolean isFull() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public void disband() {
        // TODO implement here

    }

    /**
     * @param host 
     * @param timePerRound 
     * @return
     */
    public void setTimePerRound(User host, Duration timePerRound) {
        // TODO implement here

    }

    /**
     * @param host 
     * @param isRated 
     * @return
     */
    public void setRated(User host, boolean isRated) {
        // TODO implement here

    }

}