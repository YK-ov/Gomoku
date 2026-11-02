package GameCore;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */
public class Move {

    /**
     * Default constructor
     */
    public Move() {
    }

    /**
     * 
     */
    private int xCoordinate;

    /**
     * 
     */
    private int yCoordinate;

    /**
     * 
     */
    private ColorType color;

    /**
     * 
     */
    private LocalDateTime playedAt;

    /**
     * @param x 
     * @param y 
     * @param color
     */
    public Move(int x, int y, ColorType color) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.color = color;
        this.playedAt = LocalDateTime.now();
    }

}