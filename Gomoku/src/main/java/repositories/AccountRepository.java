package repositories;

import UsersAuthAndStatistics.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    List<Account> findAll();
    Optional<Account> findById(String id);
    Account save(Account account);
    void deleteById(String id);
    Optional<Account> findByNickName(String nickName);
}
