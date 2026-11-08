package com.example.gomoku.AI;

import com.example.gomoku.GameCore.Board;
import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.GameCore.Move;

/**
 * 
 */
public interface MoveStrategy {
    public Move chooseMove(Board board, ColorType color);
}