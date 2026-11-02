package Match;

import GameCore.ColorType;
import UsersAuthAndStatistics.Leaderboard;
import UsersAuthAndStatistics.User;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class RandomMatchMaker {

    /**
     * Default constructor
     */
    public RandomMatchMaker() {
    }

    /**
     * 
     */
    private Queue currentQueue;

    /**
     * 
     */
    private SpectateManager spectateManager;

    /**
     * 
     */
    private Leaderboard leaderboard;



    /**
     * @param spectateManager 
     * @param leaderboard
     */
    public RandomMatchMaker(SpectateManager spectateManager, Leaderboard leaderboard) {
        // TODO implement here
    }

    /**
     * @param user 
     * @return
     */
    public void joinQueue(User user) {
        // TODO implement here

    }

    /**
     * @param user 
     * @return
     */
    public void leaveQueue(User user) {
        // TODO implement here

    }

    /**
     * @return
     */
    public void searchForSimilarRating() {
        // TODO implement here

    }

    /**
     * @param isRated 
     * @param firstUser 
     * @param secondUser 
     * @param sM 
     * @return
     */
    public HumanMatch startMatchWhenFoundOpponents(boolean isRated, User firstUser, User secondUser, SpectateManager sM) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ColorType randomizeColor() {
        // TODO implement here
        return null;
    }

}