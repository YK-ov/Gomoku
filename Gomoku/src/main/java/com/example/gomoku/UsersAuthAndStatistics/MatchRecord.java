package com.example.gomoku.UsersAuthAndStatistics;

import com.example.gomoku.GameCore.MatchEndReason;
import com.example.gomoku.GameCore.MatchResult;
import com.example.gomoku.GameCore.Move;

import java.time.LocalDateTime;
import java.util.*;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "matchId")
@ToString

@Entity
@Table(name = "match_records")
public class MatchRecord {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "white_id")
    private User white;

    /**
     * 
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "black_id")
    private User black;

    /**
     * 
     */
    @Enumerated(EnumType.STRING)
    private MatchResult result;

    /**
     * 
     */
    @Column(name = "is_rated")
    private boolean isRated;

    /**
     * 
     */
    @Column(name = "rating_change_white")
    private int ratingChangeWhite;

    /**
     * 
     */
    @Column(name = "rating_change_black")
    private int ratingChangeBlack;

    /**
     * 
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<Move> moves;

    /**
     * 
     */
    @Column(name = "started_at")
    private LocalDateTime startedAt;

    /**
     * 
     */
    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    /**
     * 
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "end_reason")
    private MatchEndReason endReason;

    /**
     * 
     */
    @Id
    @Column(name = "match_id")
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