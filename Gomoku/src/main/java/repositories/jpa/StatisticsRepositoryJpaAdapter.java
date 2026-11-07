package repositories.jpa;

import UsersAuthAndStatistics.Account;
import UsersAuthAndStatistics.Statistics;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import repositories.StatisticsRepository;

import java.util.Optional;

@Repository
public class StatisticsRepositoryJpaAdapter implements StatisticsRepository {
    private StatisticsJpaRepository delegate;

    public StatisticsRepositoryJpaAdapter(StatisticsJpaRepository delegate) {
        this.delegate = delegate;
    }

    @Override
    public Optional<Statistics> findByAccount(Account account) {
        return delegate.findByAccount(account);
    }

    @Override
    public Optional<Statistics> findByAccount_NickName(String nickName) {
        return delegate.findByAccount_NickName(nickName);
    }

    @Override
    public Optional<Statistics> findByAccount_Id(String id) {
        return delegate.findByAccount_Id(id);
    }

    @Override
    public Optional<Statistics> findTopByOrderByAccountDesc(Pageable pageable) {
        return delegate.findTopByOrderByAccountDesc(pageable);
    }
}
