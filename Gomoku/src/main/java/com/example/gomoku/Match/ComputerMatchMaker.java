package com.example.gomoku.Match;

import com.example.gomoku.AI.Difficulty;
import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.UsersAuthAndStatistics.User;

import java.time.Duration;

/**
 * 
 */
public class ComputerMatchMaker {

    /**
     * Default constructor
     */
    public ComputerMatchMaker() {
    }

    /**
     * 
     */
    private SpectateManager spectateManager;


    /**
     * @param spectateManager
     */
    public ComputerMatchMaker(SpectateManager spectateManager) {
        this.spectateManager = spectateManager;
    }

    /**
     * @param isRated 
     * @param user 
     * @param userColor 
     * @param difficulty 
     * @param sM 
     * @return
     */
    public ComputerMatch startComputerMatch(boolean isRated, User user, ColorType userColor, Difficulty difficulty, SpectateManager sM) {
        isRated = false;
        ColorType computerColor = null;

        if (userColor == ColorType.White){
            computerColor = ColorType.Black;
        }
        else if (userColor == ColorType.Black){
            computerColor = ColorType.White;
        }

        Duration timePerRound = timePerRoundFor(difficulty);

        return new ComputerMatch(timePerRound, isRated, user, userColor, computerColor, difficulty, sM);
    }

    /**
     * @return
     */
    public ColorType randomizeColor() {
        int randomNum = (int)(Math.random() * 2);
        ColorType playerColor = null;

        if (randomNum == 0){
            playerColor = ColorType.White;
        }
        else {
            playerColor = ColorType.Black;
        }

        return playerColor;
    }

    /**
     * @param difficulty 
     * @return
     */
    public Duration timePerRoundFor(Difficulty difficulty) {
        Duration timePerRound = null;

        if (difficulty == Difficulty.Easy){
            timePerRound = Duration.ofMinutes(10);
        }
        else if (difficulty == Difficulty.Medium){
            timePerRound = Duration.ofMinutes(5);
        }
        else if (difficulty == Difficulty.Hard){
            timePerRound = Duration.ofMinutes(3);
        }


        return timePerRound;
    }

}