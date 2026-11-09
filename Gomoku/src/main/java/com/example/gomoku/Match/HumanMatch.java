package com.example.gomoku.Match;

import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.GameCore.MatchResult;
import com.example.gomoku.UsersAuthAndStatistics.RatingCalculator;
import com.example.gomoku.UsersAuthAndStatistics.User;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

/**
 * 
 */
public class HumanMatch extends Match {
    /**
     * @param timePerRound 
     * @param isRated 
     * @param firstUser 
     * @param secondUser 
     * @param firstColor 
     * @param secondColor 
     * @param sM
     */

    private RatingCalculator ratingCalculator;

    public HumanMatch(Duration timePerRound, boolean isRated, User firstUser, User secondUser, ColorType firstColor, ColorType secondColor, SpectateManager sM, RatingCalculator rT) {
        super(timePerRound, isRated, sM);

        HumanPlayer firstPlayer = new HumanPlayer(firstColor, firstUser);
        HumanPlayer secondPlayer = new HumanPlayer(secondColor, secondUser);

        addPlayer(firstPlayer);
        addPlayer(secondPlayer);

        this.ratingCalculator = rT;
    }

    /**
     * @param result 
     * @return
     */
    protected int applyRatings(MatchResult result) {
        User whiteUser = null;
        User blackUser = null;

        for (int i = 0; i < super.getPlayersInMatch().size(); i++){
            if (super.getPlayersInMatch().get(i).getColor() == ColorType.White){
                whiteUser = ((HumanPlayer) getPlayersInMatch().get(i)).getUser();
            }
            else if (super.getPlayersInMatch().get(i).getColor() == ColorType.Black){
                blackUser = ((HumanPlayer) getPlayersInMatch().get(i)).getUser();
            }
        }

        return ratingCalculator.updateRatings(whiteUser, blackUser, result);
    }

    /**
     * @return
     */
    protected void afterMove() {
        // TODO implement here

    }

}