package com.example.gomoku.services;

import com.example.gomoku.UsersAuthAndStatistics.Leaderboard;
import com.example.gomoku.repositories.StatisticsRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {
    private final StatisticsRepository statisticsRepository;
    private final Leaderboard leaderboard;

    public StatisticsService(StatisticsRepository statisticsRepository, Leaderboard leaderboard) {
        this.statisticsRepository = statisticsRepository;
        this.leaderboard = leaderboard;
    }



}
