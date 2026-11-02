package Match;

import AI.*;
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
        super(color);

        this.difficulty = difficulty;
        addStrategyBasedOnDifficulty();
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
        if (difficulty == Difficulty.Easy){
            this.strategy = new MinMaxStrategy();
        }
        else if (difficulty == Difficulty.Medium){
            this.strategy = new RandomStrategy();
        }
        else if (difficulty == Difficulty.Hard){
            this.strategy = new HeuristicsStrategy();
        }
    }

}