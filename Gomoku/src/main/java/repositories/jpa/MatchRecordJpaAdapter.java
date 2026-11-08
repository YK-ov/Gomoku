package repositories.jpa;

import UsersAuthAndStatistics.MatchRecord;
import UsersAuthAndStatistics.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import repositories.MathRecordRepository;

import java.util.List;
import java.util.UUID;

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
