package Match;

import AI.Difficulty;
import AI.MoveStrategy;
import GameCore.Board;
import GameCore.ColorType;
import GameCore.Move;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class ComputerPlayer extends Player {

    /**
     * Default constructor
     */
    public ComputerPlayer() {
    }

    /**
     * 
     */
    private Difficulty difficulty;

    /**
     * 
     */
    private MoveStrategy strategy;

    /**
     * @param color 
     * @param difficulty
     */
    public ComputerPlayer(ColorType color, Difficulty difficulty) {
        MoveStrategy strategy = new MoveStrategy() {
            @Override
            public Move chooseMove(Board board, ColorType color) {
                return null;
            }
        }; // composition
        this.strategy = strategy;

    }

    /**
     * @param board 
     * @return
     */
    public Move chooseMove(Board board) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    private void addStrategyBasedOnDifficulty() {
        // TODO implement here

    }

}