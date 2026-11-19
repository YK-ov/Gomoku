package com.example.gomoku;

import com.example.gomoku.Match.Queue;
import com.example.gomoku.Match.RandomMatchMaker;
import com.example.gomoku.Match.SpectateManager;
import com.example.gomoku.UsersAuthAndStatistics.Leaderboard;
import com.example.gomoku.UsersAuthAndStatistics.Statistics;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GomokuApplication {
    public static void main(String[] args){
        SpringApplication.run(GomokuApplication.class, args);
    }

}
