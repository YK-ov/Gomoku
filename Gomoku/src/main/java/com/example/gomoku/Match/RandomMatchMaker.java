package com.example.gomoku.Match;

import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.UsersAuthAndStatistics.Leaderboard;
import com.example.gomoku.UsersAuthAndStatistics.RatingCalculator;
import com.example.gomoku.UsersAuthAndStatistics.User;

import java.time.Duration;

/**
 * 
 */
public class RandomMatchMaker {
    public RandomMatchMaker() {
    }

    private Queue currentQueue;
    private SpectateManager spectateManager;
    private Leaderboard leaderboard;
    private RatingCalculator ratingCalculator;

    public RandomMatchMaker(SpectateManager spectateManager, Leaderboard leaderboard, RatingCalculator rT) {
        this.currentQueue = new Queue();
        this.spectateManager = spectateManager;
        this.leaderboard = leaderboard;
        this.ratingCalculator = rT;
    }

    public void joinQueue(User user) {
        currentQueue.addUser(user);
    }

    public void leaveQueue(User user) {
        currentQueue.removeUser(user);
    }

    public void searchForSimilarRating() {
        // TODO implement here

    }

    public HumanMatch startMatchWhenFoundOpponents(boolean isRated, User firstUser, User secondUser, SpectateManager sM) {
        Duration timePerRound = Duration.ofMinutes(3);

        ColorType firstPlayerColor = null;
        ColorType secondPlayerColor = null;

        while (firstPlayerColor == secondPlayerColor){
            firstPlayerColor = randomizeColor();
            secondPlayerColor = randomizeColor();
        }

        return new HumanMatch(timePerRound, isRated, firstUser, secondUser, firstPlayerColor, secondPlayerColor, sM, ratingCalculator);
    }

    public ColorType randomizeColor() {
        int randomNum = (int)(Math.random() * 2);

        if (randomNum == 0){
            return ColorType.White;
        }
        else {
            return ColorType.Black;
        }

    }

}