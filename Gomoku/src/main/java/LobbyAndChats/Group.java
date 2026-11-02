package LobbyAndChats;

import GameCore.ColorType;
import Match.HumanMatch;
import Match.SpectateManager;
import UsersAuthAndStatistics.User;

import java.io.*;
import java.time.Duration;
import java.util.*;

/**
 * 
 */
public class Group {

    /**
     * Default constructor
     */
    public Group() {
    }

    /**
     * 
     */
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
        // TODO implement here
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