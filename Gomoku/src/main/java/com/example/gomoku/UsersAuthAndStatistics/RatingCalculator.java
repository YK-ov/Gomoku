package com.example.gomoku.UsersAuthAndStatistics;

import com.example.gomoku.GameCore.MatchResult;


public class RatingCalculator {
    private int kFactor;
    private Leaderboard leaderboard;

    public RatingCalculator(int kFactor, Leaderboard leaderboard) {
        this.kFactor = kFactor;
        this.leaderboard = leaderboard;
    }

    public int updateRatings(Account whiteAccount, Account blackAccount, MatchResult result) {
        if (result == MatchResult.NoResult){
            leaderboard.getStatisticsOf(whiteAccount).recordDraw(0);
            leaderboard.getStatisticsOf(blackAccount).recordDraw(0);
        }
        else if (result == MatchResult.WhiteWon){
            //leaderboard.getStatisticsOf(whiteAccount).
        }

        return 0;
    }

}