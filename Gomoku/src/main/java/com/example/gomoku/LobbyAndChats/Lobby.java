package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.GameCore.MatchResult;
import com.example.gomoku.GameCore.Move;
import com.example.gomoku.Match.Match;
import com.example.gomoku.UsersAuthAndStatistics.Account;
import com.example.gomoku.Match.MatchStatus;
import com.example.gomoku.Match.MatchListener;

import java.util.*;

/**
 * 
 */
public class Lobby implements MatchListener {

//    /**
//     * Default constructor
//     */
//    public Lobby() {
//    }
//
//    /**
//     *
//     */
    private List<Match> activeMatches;

    /**
     * 
     */
    private Map<String, MatchChat> matchChats;

    private LobbyChat lobbyChat;

    private ActiveAccountsBoard activeAccountsBoard;

    /**
     * 
     */
    public Lobby() {
        this.activeMatches = new ArrayList<Match>();
        this.lobbyChat = new LobbyChat();
        this.activeAccountsBoard = new ActiveAccountsBoard();

        this.matchChats = new HashMap<>();
    }

    /**
     * @param account 
     * @return
     */
    public void join(Account account) {
        // TODO implement here

    }

    /**
     * @param account 
     * @return
     */
    public void leave(Account account) {
        // TODO implement here

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

    /**
     * @param match 
     * @return
     */
    public MatchChat registerMatch(Match match) {
        // TODO implement here
        return null;
    }

    /**
     * @param match 
     * @return
     */
    public void unregisterMatch(Match match) {
        // TODO implement here

    }

}