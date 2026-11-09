package com.example.gomoku.Match;

import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.GameCore.Move;
import com.example.gomoku.UsersAuthAndStatistics.User;

import lombok.*;

@Getter
@Setter

/**
 * 
 */
public class HumanPlayer extends Player {

    /**
     * Default constructor
     */
    public HumanPlayer() {
    }

    /**
     * 
     */
    private User user;

    /**
     * @param color 
     * @param user
     */
    public HumanPlayer(ColorType color, User user) {
        super(color);
        this.user = user;
    }

    /**
     * @param x 
     * @param y 
     * @return
     */
    public Move makeMove(int x, int y) {
        return new Move(x, y, super.getColor());
    }

}