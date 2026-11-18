package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.Match.HumanMatch;
import com.example.gomoku.Match.SpectateManager;
import com.example.gomoku.UsersAuthAndStatistics.RatingCalculator;
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

    private RatingCalculator ratingCalculator;


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
        Map<User, ColorType> temp = host;
        host = guest;
        guest = temp;
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
    public HumanMatch startHostGuestGame(Duration timer, boolean isRated, User firstUser, User secondUser, ColorType firstColor, ColorType secondColor, SpectateManager sM, RatingCalculator rC) {
        return new HumanMatch(timer, isRated, firstUser, secondUser, firstColor, secondColor, sM, rC);
    }

    /**
     * @param user 
     * @return
     */
    public void leave(User user) {
        this.host.put(null, null);
        this.guest.put(null, null);
    }

    /**
     * @param user 
     * @param color 
     * @return
     */
    public void chooseColor(User user, ColorType color) {
        if (host.containsKey(user)) {
            host.put(user, color);
        }
        else if (guest.containsKey(user)) {
            if (host.get(user) == color) {
                if (color == ColorType.Black){
                    guest.put(user, ColorType.White);
                }
                else {
                    guest.put(user, ColorType.Black);
                }
            }
        }

    }

    /**
     * @return
     */
    public List<ColorType> checkAvailableColors() {


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