package AI;

import GameCore.Board;
import GameCore.ColorType;
import GameCore.Move;

import java.io.*;
import java.util.*;

/**
 * 
 */
public interface MoveStrategy {
    public Move chooseMove(Board board, ColorType color);
}