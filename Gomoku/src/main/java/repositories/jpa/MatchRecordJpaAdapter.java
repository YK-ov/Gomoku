package repositories.jpa;

import UsersAuthAndStatistics.MatchRecord;
import UsersAuthAndStatistics.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import repositories.MathRecordRepository;

public class MatchRecordJpaAdapter implements MathRecordRepository {
    private final MatchRecordJpaRepository delegate;

    public MatchRecordJpaAdapter(MatchRecordJpaRepository delegate) {
        this.delegate = delegate;
    }

    @Override
    public Page<MatchRecord> findByWhiteOrBlackOrderByEndedAtDesc(User white, User black, Pageable pageable) {
        return delegate.findByWhiteOrBlackOrderByEndedAtDesc(white, black, pageable);
    }
}
