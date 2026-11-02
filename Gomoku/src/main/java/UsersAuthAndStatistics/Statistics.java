package UsersAuthAndStatistics;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Statistics {

    /**
     * Default constructor
     */
    public Statistics() {
    }

    /**
     * 
     */
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