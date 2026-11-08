package repositories;

import UsersAuthAndStatistics.Statistics;

import java.util.List;
import java.util.Optional;

public interface StatisticsRepository {
    Optional<Statistics> findByAccountNickName(String nickName);
    Optional<Statistics> findByAccountId(String id);
    List<Statistics> findTopByRating(int limit);
    Statistics save(Statistics statistics);
    void deleteByAccountId(String id);
}
