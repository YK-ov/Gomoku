package com.example.gomoku.Match;

import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.UsersAuthAndStatistics.Leaderboard;
import com.example.gomoku.UsersAuthAndStatistics.RatingCalculator;
import com.example.gomoku.UsersAuthAndStatistics.User;
import com.example.gomoku.UsersAuthAndStatistics.UserActivity;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

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
    private int currentUserRating;
    private User currentUser;

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
        List<Map.Entry<User, Instant>> entryList = new ArrayList<>(currentQueue.getAll().entrySet());
        LinkedHashMap<User, Instant> result = new LinkedHashMap<>();

        Instant now = Instant.now();

        entryList.sort(Map.Entry.comparingByValue());

        for (Map.Entry<User, Instant> entry : entryList) {
            result.put(entry.getKey(), entry.getValue());
        }

        int index = 0;

        for (Map.Entry<User, Instant> entry : result.entrySet()) {
            Duration currentTimeWaiting = Duration.between(Instant.now(), entry.getValue());

            if (currentTimeWaiting.toSeconds() > 30){
                if (currentTimeWaiting.toSeconds() > 60){
                    if (currentTimeWaiting.toSeconds() > 120){
                        if (currentTimeWaiting.toSeconds() > 350){

                        }

                    }
                }

            }

            boolean pairMatched = false;

            if (index != 0){
                int ratingLocalUserRating = leaderboard.getRating(entry.getKey());

                if (Math.abs(ratingLocalUserRating - currentUserRating) <= 15){
                    User localUser = entry.getKey();

                    startMatchWhenFoundOpponents(true, localUser, currentUser, spectateManager);

                    currentQueue.removeUser(localUser);
                    currentQueue.removeUser(currentUser);

                    pairMatched = true;
                }

            }


            if (index == 0){
                index++;
            }

            if (!pairMatched){
                currentUserRating = leaderboard.getStatisticsOf(entry.getKey()).getRating();
                currentUser = entry.getKey();
            }

        }
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
