package com.example.gomoku.Match;

import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.UsersAuthAndStatistics.Leaderboard;
import com.example.gomoku.UsersAuthAndStatistics.RatingCalculator;
import com.example.gomoku.UsersAuthAndStatistics.User;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * 
 */
//@Component
public class RandomMatchMaker {
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

    public synchronized void joinQueue(User user) {
        currentQueue.addUser(user);
    }

    public synchronized void leaveQueue(User user) {
        currentQueue.removeUser(user);
    }

    public synchronized List<HumanMatch> searchForSimilarRating() {
        List<HumanMatch> foundMatches = new ArrayList<>();

        List<Map.Entry<User, Instant>> entryList = new ArrayList<>(currentQueue.getAll().entrySet());

        entryList.sort(Map.Entry.comparingByValue());

        while (!entryList.isEmpty()) {
            Instant now = Instant.now();
            User firstUser = entryList.getFirst().getKey();
            Duration firstUserTimeWaiting = Duration.between(entryList.getFirst().getValue(), now);
            int firstUserRating = leaderboard.getRating(firstUser);
            int firstUserRatingLimit = getRatingLimit(firstUserTimeWaiting);

            int index = 0;
            boolean matched = false;

            for (Map.Entry<User, Instant> entry : entryList) {


                if (index > 0) {
                    User currentUser = entry.getKey();
                    int currentUserRating = leaderboard.getRating(entry.getKey());
                    Duration currentUserTimeWaiting = Duration.between(entry.getValue(), now);
                    int currentUserRatingLimit = getRatingLimit(currentUserTimeWaiting);

                    int mutualLimit = Math.min(firstUserRatingLimit, currentUserRatingLimit);

                    if (Math.abs(firstUserRating - currentUserRating) <= mutualLimit) {
                        matched = true;

                        foundMatches.add(startMatchWhenFoundOpponents(true, firstUser, currentUser, spectateManager));

                        entryList.remove(entryList.getFirst());
                        entryList.remove(entry);

                        currentQueue.removeUser(firstUser);
                        currentQueue.removeUser(currentUser);

                        break;
                    }

                }

                if (index == 0) {
                    index++;
                }
            }

            if (!matched) {
                entryList.remove(entryList.getFirst());
            }

        }

        return foundMatches;
    }

    private static int getRatingLimit(Duration currentTimeWaiting) {
        int ratingLimit = 15;

        if (currentTimeWaiting.toSeconds() >= 600){
            return 500;
        }

        if (currentTimeWaiting.toSeconds() >= 350){
            return 150;
        }

        if (currentTimeWaiting.toSeconds() >= 120){
            return 100;
        }

        if (currentTimeWaiting.toSeconds() >= 60){
            return 60;
        }

        if (currentTimeWaiting.toSeconds() >= 30){
            return 30;
        }

        return ratingLimit;
    }

    public HumanMatch startMatchWhenFoundOpponents ( boolean isRated, User firstUser, User
        secondUser, SpectateManager sM){
            Duration timePerRound = Duration.ofMinutes(3);

            ColorType firstPlayerColor = null;
            ColorType secondPlayerColor = null;

            while (firstPlayerColor == secondPlayerColor) {
                firstPlayerColor = randomizeColor();
                secondPlayerColor = randomizeColor();
            }

            return new HumanMatch(timePerRound, isRated, firstUser, secondUser, firstPlayerColor, secondPlayerColor, sM, ratingCalculator);
        }

        public ColorType randomizeColor () {
            int randomNum = (int) (Math.random() * 2);

            if (randomNum == 0) {
                return ColorType.White;
            } else {
                return ColorType.Black;
            }

        }

}
