package repositories;

import UsersAuthAndStatistics.MatchRecord;
import UsersAuthAndStatistics.User;

import java.util.List;

public interface MathRecordRepository {
    List<MatchRecord> findHistoryOf(User user, int page, int size);
    MatchRecord save(MatchRecord matchRecord);
}
