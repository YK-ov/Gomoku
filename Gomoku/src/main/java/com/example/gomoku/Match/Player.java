package com.example.gomoku.Match;

import com.example.gomoku.GameCore.ColorType;

/**
 * 
 */
public abstract class Player {

    /**
     * Default constructor
     */
    public Player() {
    }

    /**
     * 
     */
    private ColorType color;


    /**
     * @param color
     */
    public Player(ColorType color) {
        this.color = color;
    }

}