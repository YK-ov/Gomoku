package com.example.gomoku.Match;

import com.example.gomoku.GameCore.MatchResult;
import com.example.gomoku.GameCore.Move;
import com.example.gomoku.UsersAuthAndStatistics.Admin;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 */
public class SpectateManager implements MatchListener{
    private Map<String, Map<Admin, MatchListener>> spectators;

    /**
     *
     */
    private Map<String, Match> activeMatches;





    /**
     * 
     */
    public SpectateManager() {
        this.spectators = new ConcurrentHashMap<>();
        this.activeMatches = new ConcurrentHashMap<>();
    }

    /**
     * @param match 
     * @return
     */
    public void registerMatch(Match match) {
        spectators.putIfAbsent(match.getMatchId(), new ConcurrentHashMap<>());  // ConcurrentHashMap bo bezpieczna wersja dla wielu watkow, wielu watkow beda mogly robic operacje na mapie
        activeMatches.put(match.getMatchId(), match);
        match.addListener(this);
    }

    /**
     * @param admin 
     * @param matchId 
     * @param listener 
     * @return
     */
    public void spectate(Admin admin, String matchId, MatchListener listener) {
        Map<Admin, MatchListener> watchers = spectators.get(matchId);
        if (watchers == null) {
            throw new IllegalArgumentException("Brak partii o id " + matchId);
        }
        watchers.put(admin, listener);
    }

    /**
     * @param admin 
     * @param matchId 
     * @return
     */
    public void stopSpectating(Admin admin, String matchId) {
        if (admin == null){
            throw new IllegalStateException("Operacja jest dostępna tylko administratorowi");
        }

        spectators.get(matchId).remove(admin);
    }

    /**
     * @param match 
     * @param move 
     * @return
     */
    @Override
    public void onMoveMade(Match match, Move move) {
        if (!activeMatches.containsKey(match.getMatchId())){
            throw new IllegalStateException("Brak partii o id " + match.getMatchId());
        }

        for (MatchListener listener : spectators.get(match.getMatchId()).values()) {
            listener.onMoveMade(match, move);
        }
    }

    /**
     * @param match 
     * @param status 
     * @return
     */
    @Override
    public void onStatusChanged(Match match, MatchStatus status) {
        if (!activeMatches.containsKey(match.getMatchId())){
            throw new IllegalStateException("Brak partii o id " + match.getMatchId());
        }

        for (MatchListener listener : spectators.get(match.getMatchId()).values()) {
            listener.onStatusChanged(match, status);
        }
    }

    /**
     * @param match 
     * @param result 
     * @return
     */
    @Override
    public void onMatchFinished(Match match, MatchResult result) {
        if (!activeMatches.containsKey(match.getMatchId())){
            throw new IllegalStateException("Brak partii o id " + match.getMatchId());
        }

        for (MatchListener listener : spectators.get(match.getMatchId()).values()) {
            listener.onMatchFinished(match, result);
        }

        activeMatches.remove(match.getMatchId());
        spectators.remove(match.getMatchId());
    }

    /**
     * @param admin 
     * @return
     */
    public List<Match> getActiveMatches(Admin admin) {
        if (admin == null){
            throw new NullPointerException("Operacja jest dostępna tylko administratorowi");    // na diagramie warstwy to bylo, bo chodzilo o pokazanie logiki niezaleznie od technolohii implementacji
                                                                                                // (akurat w springu bede to prawdziwie implementowal za pomoca sprawdzania endpointu czy rola jest admin)
        }

        return List.copyOf(activeMatches.values());
    }

}