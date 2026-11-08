package com.example.gomoku.Match;

import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.UsersAuthAndStatistics.Leaderboard;
import com.example.gomoku.UsersAuthAndStatistics.User;

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
        this.currentQueue = new Queue();
        this.spectateManager = spectateManager;
        this.leaderboard = leaderboard;
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