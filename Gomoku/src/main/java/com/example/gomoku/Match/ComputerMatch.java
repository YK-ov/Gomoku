package com.example.gomoku.Match;

import com.example.gomoku.AI.Difficulty;
import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.GameCore.MatchResult;
import com.example.gomoku.UsersAuthAndStatistics.User;
import com.example.gomoku.UsersAuthAndStatistics.*;

import java.time.Duration;
import java.util.List;

/**
 * 
 */
public class ComputerMatch extends Match {
    public ComputerMatch(Duration timePerRound, boolean isRated, User user, ColorType userColor, ColorType computerColor, Difficulty difficulty, SpectateManager sM) {
        super(timePerRound, isRated, sM);

        HumanPlayer humanPlayer = new HumanPlayer(userColor, user);
        addPlayer(humanPlayer);

        ComputerPlayer computerPlayer = new ComputerPlayer(computerColor, difficulty);
        addPlayer(computerPlayer);
    }

    /**
     * @param result 
     * @return
     */
    @Override
    protected int applyRatings(MatchResult result) {

        return 0;  // mecz z kompterem nie zmienia ratingu
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