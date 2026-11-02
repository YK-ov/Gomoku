package Match;

import GameCore.MatchResult;
import GameCore.Move;

import java.io.*;
import java.util.*;

/**
 * 
 */
public interface MatchListener {
    public void onMoveMade(Match match, Move move);

    /**
     * @param match 
     * @param status 
     * @return
     */
    public void onStatusChanged(Match match, MatchStatus status);

    /**
     * @param match 
     * @param result 
     * @return
     */
    public void onMatchFinished(Match match, MatchResult result);

}