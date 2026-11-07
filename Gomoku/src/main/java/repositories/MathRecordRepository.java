package repositories;

import UsersAuthAndStatistics.MatchRecord;
import UsersAuthAndStatistics.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MathRecordRepository {
    Page<MatchRecord> findByWhiteOrBlackOrderByEndedAtDesc(User white, User black, Pageable pageable);
}
