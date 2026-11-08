package com.example.gomoku.Match;

import com.example.gomoku.GameCore.MatchResult;
import com.example.gomoku.GameCore.Move;

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