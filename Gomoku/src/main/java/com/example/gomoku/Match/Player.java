package com.example.gomoku.Match;

import com.example.gomoku.GameCore.ColorType;

import lombok.*;
/**
 * 
 */

@Getter
@Setter

public abstract class Player {
    private ColorType color;

    public Player(ColorType color) {
        this.color = color;
    }

}