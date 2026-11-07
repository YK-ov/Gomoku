package repositories;

import UsersAuthAndStatistics.Account;
import UsersAuthAndStatistics.Statistics;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StatisticsRepository {
    Optional<Statistics> findByAccount(Account account);
    Optional<Statistics> findByAccount_NickName(String nickName);
    Optional<Statistics> findByAccount_Id(String id);
    Optional<Statistics> findTopByOrderByAccountDesc(Pageable pageable);
}
