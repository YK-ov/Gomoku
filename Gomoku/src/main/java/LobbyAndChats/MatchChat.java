package LobbyAndChats;

import GameCore.MatchResult;
import GameCore.Move;
import Match.Match;
import Match.MatchStatus;
import UsersAuthAndStatistics.Account;
import Match.MatchListener;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class MatchChat extends Chat implements MatchListener {

    /**
     * Default constructor
     */
    public MatchChat() {
    }

    /**
     * 
     */
    private Match match;


    /**
     * @param match
     */
    public MatchChat(Match match) {
        this.match = match;
    }

    /**
     * @param match 
     * @param move
     */
    public void onMoveMade(Match match, Move move) {
        // TODO implement here
    }

    /**
     * @param match 
     * @param status
     */
    public void onStatusChanged(Match match, MatchStatus status) {
        // TODO implement here
    }

    /**
     * @param match 
     * @param result
     */
    public void onMatchFinished(Match match, MatchResult result) {
        // TODO implement here
    }

    /**
     * @param account 
     * @return
     */
    public boolean canAccountUseChat(Account account) {
        // TODO implement here
        return false;
    }

    /**
     * @param account 
     * @return
     */
    //public abstract boolean canAccountUseChat(Account account);

}