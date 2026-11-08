package com.example.gomoku.repositories.jpa;

import com.example.gomoku.UsersAuthAndStatistics.MatchRecord;
import com.example.gomoku.UsersAuthAndStatistics.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRecordJpaRepository extends JpaRepository<MatchRecord, String> {
    Page<MatchRecord> findByWhiteOrBlackOrderByEndedAtDesc(User user, Pageable pageable);
}
