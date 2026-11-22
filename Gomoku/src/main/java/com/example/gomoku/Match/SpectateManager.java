package com.example.gomoku.Match;

import com.example.gomoku.GameCore.MatchResult;
import com.example.gomoku.GameCore.Move;
import com.example.gomoku.UsersAuthAndStatistics.Admin;
import com.example.gomoku.UsersAuthAndStatistics.User;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 */
@Component
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

        Map<Admin, MatchListener> watchers = spectators.get(matchId);
        if (watchers != null) {
            watchers.remove(admin);
        }

    }

    /**
     * @param match 
     * @param move 
     * @return
     */
    @Override
    public void onMoveMade(Match match, Move move) {
        Map<Admin, MatchListener> watchers = spectators.get(match.getMatchId());

        if (watchers != null) {
            try {
                for (MatchListener listener : spectators.get(match.getMatchId()).values()) {
                    listener.onMoveMade(match, move);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param match 
     * @param status 
     * @return
     */
    @Override
    public void onStatusChanged(Match match, MatchStatus status) {
        Map<Admin, MatchListener> watchers = spectators.get(match.getMatchId());

        if (watchers != null) {
            try {
                for (MatchListener listener : spectators.get(match.getMatchId()).values()) {
                    listener.onStatusChanged(match, status);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param match 
     * @param result 
     * @return
     */
    @Override
    public void onMatchFinished(Match match, MatchResult result) {
        Map<Admin, MatchListener> watchers = spectators.get(match.getMatchId());

        if (watchers != null) {
            for (MatchListener listener : watchers.values()) {
                try {
                    listener.onMatchFinished(match, result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        activeMatches.remove(match.getMatchId());
        spectators.remove(match.getMatchId());
    }

    /**
     * @param admin 
     * @return
     */
    public List<Match> getActiveMatches(Admin admin) {
        if (admin == null) {
            throw new IllegalArgumentException("Operacja jest dostępna tylko administratorowi");
        }

        return List.copyOf(activeMatches.values());
    }

}