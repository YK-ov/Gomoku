package com.example.gomoku.GameCore;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Move {
    private int xCoordinate;

    private int yCoordinate;

    private ColorType color;

    private LocalDateTime playedAt;

    public Move(int x, int y, ColorType color) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.color = color;
        this.playedAt = LocalDateTime.now();
    }

}