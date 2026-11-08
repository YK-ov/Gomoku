package repositories.jpa;

import UsersAuthAndStatistics.MatchRecord;
import UsersAuthAndStatistics.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRecordJpaRepository extends JpaRepository<MatchRecord, String> {
    Page<MatchRecord> findByWhiteOrBlackOrderByEndedAtDesc(User user, Pageable pageable);
}
