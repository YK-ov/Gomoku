package com.example.gomoku.Match;

import com.example.gomoku.GameCore.Board;
import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.GameCore.Move;
import com.example.gomoku.AI.*;

import lombok.*;

@Getter
@Setter

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
        return strategy.chooseMove(board, super.getColor());
    }

    /**
     * @return
     */
    private void addStrategyBasedOnDifficulty() {
        if (difficulty == Difficulty.Easy){
            this.strategy = new RandomStrategy();
        }
        else if (difficulty == Difficulty.Medium){
            this.strategy = new HeuristicsStrategy();
        }
        else if (difficulty == Difficulty.Hard){
            this.strategy = new MinMaxStrategy();
        }
    }

}