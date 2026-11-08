package com.example.gomoku.UsersAuthAndStatistics;

import jakarta.persistence.*;
import lombok.*;

/**
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "statistics")
public class Statistics {
    @Id
    @Column(name = "account_id")
    private String id; // id ktore jest de facto account_id, szczegol techniczny implementacyjny, jest to samo co account_id, dodany zeby hibernate przepiszcil te klase i powiazal z baza

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;

    /**
     * 
     */
    private int wins;

    /**
     * 
     */
    private int losses;

    /**
     * 
     */
    private int rating;



    /**
     * @param account
     */
    public Statistics(Account account) {
        this.account = account;
    }

    /**
     * @param ratingChange 
     * @return
     */
    public void recordWin(int ratingChange) {
        // TODO implement here

    }

    /**
     * @param ratingChange 
     * @return
     */
    public void recordLoss(int ratingChange) {
        // TODO implement here

    }

    /**
     * @param ratingChange 
     * @return
     */
    public void recordDraw(int ratingChange) {
        // TODO implement here

    }

}