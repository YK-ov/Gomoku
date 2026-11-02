package Match;

import GameCore.MatchResult;
import GameCore.Move;
import UsersAuthAndStatistics.Admin;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class SpectateManager implements MatchListener{

//    /**
//     * Default constructor
//     */
//    public SpectateManager() {
//    }
//
//    /**
//     *
//     */
    private Map<String, Map<Admin, MatchListener>> spectators;

    /**
     *
     */
    private Map<String, Match> activeMatches;





    /**
     * 
     */
    public SpectateManager() {
        this.spectators = new HashMap<>();
        this.activeMatches = new HashMap<>();
    }

    /**
     * @param match 
     * @return
     */
    public void registerMatch(Match match) {
        // TODO implement here

    }

    /**
     * @param admin 
     * @param matchId 
     * @param listener 
     * @return
     */
    public void spectate(Admin admin, String matchId, MatchListener listener) {
        // TODO implement here

    }

    /**
     * @param admin 
     * @param matchId 
     * @return
     */
    public void stopSpectating(Admin admin, String matchId) {
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
     * @param admin 
     * @return
     */
    public List<Match> getActiveMatches(Admin admin) {
        // TODO implement here
        return null;
    }

}