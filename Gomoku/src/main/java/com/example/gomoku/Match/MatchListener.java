package com.example.gomoku.Match;

import com.example.gomoku.GameCore.MatchResult;
import com.example.gomoku.GameCore.Move;


public interface MatchListener {
    void onMoveMade(Match match, Move move);
    void onStatusChanged(Match match, MatchStatus status);
    void onMatchFinished(Match match, MatchResult result);
}