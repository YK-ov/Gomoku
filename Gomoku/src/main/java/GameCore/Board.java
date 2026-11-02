package GameCore;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Board {

    /**
     * Default constructor
     */
    public Board() {
    }

    /**
     * 
     */
    private int size;

    /**
     * 
     */
    private ColorType[][] cells;

    /**
     * @param size
     */
    public Board(int size) {
        this.size = size;
        this.cells = new ColorType[size][size];
    }

    /**
     * @param move 
     * @return
     */
    public boolean isValidMove(Move move) {
        // TODO implement here
        return false;
    }

    /**
     * @param move 
     * @return
     */
    public boolean isLegal(Move move) {
        // TODO implement here
        return false;
    }

    /**
     * @param move 
     * @return
     */
    public void placeMove(Move move) {
        // TODO implement here

    }

    /**
     * @param move 
     * @return
     */
    public void undoMove(Move move) {
        // TODO implement here

    }

    /**
     * @param lastMove 
     * @return
     */
    public boolean hasFiveInRow(Move lastMove) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean isFull() {
        // TODO implement here
        return false;
    }

}