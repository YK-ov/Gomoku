package UsersAuthAndStatistics;

import GameCore.MatchEndReason;
import GameCore.MatchResult;
import GameCore.Move;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */
public class MatchRecord {

    /**
     * Default constructor
     */
    public MatchRecord() {
    }

    /**
     * 
     */
    private User white;

    /**
     * 
     */
    private User black;

    /**
     * 
     */
    private MatchResult result;

    /**
     * 
     */
    private boolean isRated;

    /**
     * 
     */
    private int ratingChangeWhite;

    /**
     * 
     */
    private int ratingChangeBlack;

    /**
     * 
     */
    private List<Move> moves;

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
    private String matchId;


    /**
     * @param id 
     * @param white 
     * @param black 
     * @param result 
     * @param isRated 
     * @param ratingChangeWhite 
     * @param ratingChangeBlack 
     * @param moves 
     * @param started 
     * @param ended 
     * @param end
     */
    public MatchRecord(String id, User white, User black, MatchResult result, boolean isRated, int ratingChangeWhite, int ratingChangeBlack, List<Move> moves, LocalDateTime started, LocalDateTime ended, MatchEndReason end) {
        this.matchId = id;
        this.white = white;
        this.black = black;
        this.result = result;
        this.isRated = isRated;
        this.ratingChangeWhite = ratingChangeWhite;
        this.ratingChangeBlack = ratingChangeBlack;
        this.moves = moves;
        this.startedAt = started;
        this.endedAt = ended;
        this.endReason = end;
    }

}