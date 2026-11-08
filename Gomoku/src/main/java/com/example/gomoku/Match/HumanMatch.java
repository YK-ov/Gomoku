package com.example.gomoku.Match;

import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.GameCore.MatchResult;
import com.example.gomoku.UsersAuthAndStatistics.User;

import java.time.Duration;

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
    public HumanMatch(Duration timePerRound, boolean isRated, User firstUser, User secondUser, ColorType firstColor, ColorType secondColor, SpectateManager sM) {
        super(timePerRound, isRated, sM);

        HumanPlayer firstPlayer = new HumanPlayer(firstColor, firstUser);
        HumanPlayer secondPlayer = new HumanPlayer(secondColor, secondUser);

        addPlayer(firstPlayer);
        addPlayer(secondPlayer);
    }

    /**
     * @param result 
     * @return
     */
    protected int applyRatings(MatchResult result) {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    protected void afterMove() {
        // TODO implement here

    }

    /**
     * @param result 
     * @return
     */
    //protected abstract int applyRatings(MatchResult result);

    /**
     * @return
     */
    //protected abstract void afterMove();

}