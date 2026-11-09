package com.example.gomoku.Match;

import com.example.gomoku.UsersAuthAndStatistics.User;
import com.example.gomoku.GameCore.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

import lombok.*;

@Getter
@Setter

/**
 * 
 */
public abstract class Match {
    protected boolean isRated;

    /**
     * 
     */
    private List<Player> playersInMatch;

    /**
     * 
     */
    private MatchStatus status;

    /**
     * 
     */
    private ColorType currentTurn;

    /**
     * 
     */
    private List<Move> moveHistory;

    /**
     * 
     */
    private List<MatchListener> listeners;

    /**
     * 
     */
    private LocalDateTime startedAt;

    /**
     * 
     */
    private LocalDateTime endedAt;

    /**
     * 
     */
    private MatchEndReason endReason;

    /**
     * 
     */
    private int maxMissedTurns;

    /**
     * 
     */
    private Board board;

    /**
     * 
     */
    private Timer timer;

    /**
     * 
     */
    private MatchResult result;

    /**
     * 
     */
    private String matchId;

    /**
     * 
     */
    private SpectateManager spectateManager;





    /**
     * @param timePerRound 
     * @param isRated 
     * @param sMr
     */
    public Match(Duration timePerRound, boolean isRated, SpectateManager sMr) {
        this.board = new Board(1000);
        this.playersInMatch = new ArrayList<>(2);
        this.moveHistory = new ArrayList<>();
        this.listeners = new ArrayList<>();

        this.timer = new Timer(timePerRound);
        this.isRated = isRated;
        this.spectateManager = sMr;
        this.matchId = UUID.randomUUID().toString();
    }

    /**
     * @param player 
     * @param move 
     * @return
     */
    public MoveResult submitMove(Player player, Move move) {


        return null;
    }

    /**
     * @param result 
     * @return
     */
    public void finish(MatchResult result) {
        // TODO implement here

    }

    /**
     * @param listener 
     * @return
     */
    public void addListener(MatchListener listener) {
        // TODO implement here

    }

    /**
     * @param listener 
     * @return
     */
    public void removeListener(MatchListener listener) {
        // TODO implement here

    }

    /**
     * @param player 
     * @return
     */
    public void handleDisconnect(Player player) {
        // TODO implement here

    }

    /**
     * @param player 
     * @return
     */
    public void handleReconnect(Player player) {
        // TODO implement here

    }

    /**
     * @param player 
     * @return
     */
    public void forfeit(Player player) {
        // TODO implement here

    }

    /**
     * @return
     */
    public Player getCurrentPlayer() {
        // TODO implement here
        return null;
    }

    /**
     * @param user 
     * @return
     */
    public Player getPlayerByUser(User user) {
        // TODO implement here
        return null;
    }

    /**
     * @param player 
     * @return
     */
    public void switchTurn(Player player) {
        // TODO implement here

    }

    /**
     * @param result 
     * @return
     */
    protected abstract int applyRatings(MatchResult result);

    //protected abstract int applyRatings(MatchResult result);

    /**
     * @return
     */
    protected abstract void afterMove();

    /**
     * @return
     */
    public void checkTimer() {
        // TODO implement here

    }

    /**
     * @return
     */
    public void skipTurn() {
        // TODO implement here

    }

    /**
     * @return
     */
    public Duration getTimeRemaining() {
        return null; // to finish
    }

    /**
     * @return
     */
    public void start() {
        // TODO implement here

    }

    public void addPlayer(Player player) {
        playersInMatch.add(player);
    }

}