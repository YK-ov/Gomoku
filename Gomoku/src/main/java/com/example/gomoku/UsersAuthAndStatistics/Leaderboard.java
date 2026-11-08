package com.example.gomoku.UsersAuthAndStatistics;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 
 */
@Component
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
        this.statisticsList = new ArrayList<>();
    }

    /**
     * @param n 
     * @return
     */
    public List<Statistics> getTopN(int n) {
        int limit = Math.min(n, statisticsList.size());
        return new ArrayList<>(statisticsList.subList(0, limit));
    }

    /**
     * @param nickName 
     * @return
     */
    public Statistics getStatisticsByName(String nickName) {
        for (int i = 0; i < statisticsList.size(); i++) {
            if (statisticsList.get(i).getAccount().getNickName().equals(nickName)) {
                return statisticsList.get(i);
            }
        }

        return null;
    }

    /**
     * @param account 
     * @return
     */
    public Statistics getStatisticsOf(Account account) {
        for (int i = 0; i < statisticsList.size(); i++) {
            if (statisticsList.get(i).getAccount().getId().equals(account.getId())) {
                return statisticsList.get(i);
            }
        }

        return null;
    }

    /**
     * @return
     */
    public void refresh() {
        Collections.sort(statisticsList, Comparator.comparingInt(Statistics::getRating).reversed());
    }

    /**
     * @param account 
     * @return
     */
    public int getRating(Account account) {
        for (int i = 0; i < statisticsList.size(); i++) {
            if (statisticsList.get(i).getAccount().getId().equals(account.getId())) {
                return statisticsList.get(i).getRating();
            }
        }

        return 0;
    }

    public void addStatistics(Statistics statistics) {
        statisticsList.add(statistics);
    }

    public void removeStatistics(Statistics statistics) {
        statisticsList.remove(statistics);
    }

}