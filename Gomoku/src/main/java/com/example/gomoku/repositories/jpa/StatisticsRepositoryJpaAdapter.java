package com.example.gomoku.repositories.jpa;

import com.example.gomoku.UsersAuthAndStatistics.Statistics;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import com.example.gomoku.repositories.StatisticsRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class StatisticsRepositoryJpaAdapter implements StatisticsRepository {
    private final StatisticsJpaRepository delegate;

    public StatisticsRepositoryJpaAdapter(StatisticsJpaRepository delegate) {
        this.delegate = delegate;
    }

    @Override
    public Optional<Statistics> findByAccountNickName(String nickName) {
        return delegate.findByAccount_NickName(nickName);
    }

    @Override
    public Optional<Statistics> findByAccountId(String id) {
        return delegate.findByAccount_Id(id);
    }

    @Override
    public List<Statistics> findTopByRating(int limit) {
        return delegate.findAllByOrderByRatingDesc(PageRequest.of(0, limit));
    }

    @Override
    public Statistics save(Statistics statistics) {
        return delegate.save(statistics);
    }

    @Override
    public void deleteByAccountId(String id) {
        delegate.deleteByAccount_Id(id);
    }
}
