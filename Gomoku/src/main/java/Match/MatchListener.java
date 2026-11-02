package Match;

import GameCore.MatchResult;
import GameCore.Move;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class MatchListener {

    /**
     * Default constructor
     */
    public MatchListener() {
    }



    /**
     * @param match 
     * @param move 
     * @return
     */
    public void onMoveMade(Match match, Move move) {
        // TODO implement here

    }

    /**
     * @param match 
     * @param status 
     * @return
     */
    public void onStatusChanged(Match match, MatchStatus status) {
        // TODO implement here

    }

    /**
     * @param match 
     * @param result 
     * @return
     */
    public void onMatchFinished(Match match, MatchResult result) {
        // TODO implement here

    }

}