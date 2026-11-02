package UsersAuthAndStatistics;

import GameCore.MatchResult;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class RatingCalculator {

    /**
     * Default constructor
     */
    public RatingCalculator() {
    }

    /**
     * 
     */
    private int kFactor;

    /**
     * 
     */
    private Leaderboard leaderboard;


    /**
     * @param kFactor 
     * @param leaderboard
     */
    public RatingCalculator(int kFactor, Leaderboard leaderboard) {
        this.kFactor = kFactor;
        this.leaderboard = leaderboard;
    }

    /**
     * @param whiteAccount 
     * @param blackAccount 
     * @param result 
     * @return
     */
    public int updateRatings(Account whiteAccount, Account blackAccount, MatchResult result) {
        // TODO implement here
        return 0;
    }

}