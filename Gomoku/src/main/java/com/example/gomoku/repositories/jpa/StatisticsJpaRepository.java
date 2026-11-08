package com.example.gomoku.repositories.jpa;

import com.example.gomoku.UsersAuthAndStatistics.Statistics;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StatisticsJpaRepository extends JpaRepository<Statistics, String> {
    Optional<Statistics> findByAccount_NickName(String nickName);
    Optional<Statistics> findByAccount_Id(String id);
    List<Statistics> findAllByOrderByRatingDesc(Pageable pageable);
    public void deleteByAccount_Id(String id);
}
