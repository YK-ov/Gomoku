package UsersAuthAndStatistics;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Leaderboard {

//    /**
//     * Default constructor
//     */
//    public Leaderboard() {
//    }
//
//    /**
//     *
//     */
    private List<Statistics> statisticsList;



    /**
     * 
     */
    public Leaderboard() {
        // TODO implement here
    }

    /**
     * @param n 
     * @return
     */
    public List<Statistics> getTopN(int n) {
        // TODO implement here
        return null;
    }

    /**
     * @param nickName 
     * @return
     */
    public Statistics getStatisticsByName(String nickName) {
        // TODO implement here
        return null;
    }

    /**
     * @param account 
     * @return
     */
    public Statistics getStatisticsOf(Account account) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void refresh() {
        // TODO implement here

    }

    /**
     * @param account 
     * @return
     */
    public int getRating(Account account) {
        // TODO implement here
        return 0;
    }

    public void addStatistics(Statistics statistics) {

    }

    public void removeStatistics(Statistics statistics) {

    }

}