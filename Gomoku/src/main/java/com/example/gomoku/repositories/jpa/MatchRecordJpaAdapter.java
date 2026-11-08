package com.example.gomoku.repositories.jpa;

import com.example.gomoku.UsersAuthAndStatistics.MatchRecord;
import com.example.gomoku.UsersAuthAndStatistics.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import com.example.gomoku.repositories.MathRecordRepository;

import java.util.List;

@Repository
public class MatchRecordJpaAdapter implements MathRecordRepository {
    private final MatchRecordJpaRepository delegate;

    public MatchRecordJpaAdapter(MatchRecordJpaRepository delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<MatchRecord> findHistoryOf(User user, int page, int size) {
        return delegate.findByWhiteOrBlackOrderByEndedAtDesc(user, PageRequest.of(page, size)).getContent();
    }

    @Override
    public MatchRecord save(MatchRecord matchRecord) {
        return delegate.save(matchRecord);
    }
}
