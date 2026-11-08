package com.example.gomoku.repositories;

import com.example.gomoku.UsersAuthAndStatistics.MatchRecord;
import com.example.gomoku.UsersAuthAndStatistics.User;

import java.util.List;

public interface MathRecordRepository {
    List<MatchRecord> findHistoryOf(User user, int page, int size);
    MatchRecord save(MatchRecord matchRecord);
}
