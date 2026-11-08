package com.example.gomoku.repositories.jpa;

import com.example.gomoku.UsersAuthAndStatistics.Account;
import org.springframework.stereotype.Repository;
import com.example.gomoku.repositories.AccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AccountRepositoryJpaAdapter implements AccountRepository {
    private final AccountJpaRepository delegate;

    public AccountRepositoryJpaAdapter(AccountJpaRepository delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<Account> findAll() {
        return delegate.findAll();
    }

    @Override
    public Optional<Account> findById(String id) {
        return delegate.findById(id);
    }

    @Override
    public Account save(Account account) {
        if (account.getId() == null || account.getId().isBlank()) {
            account.setId(UUID.randomUUID().toString());
        }

        return delegate.save(account);
    }

    @Override
    public void deleteById(String id) {
        delegate.deleteById(id);
    }

    @Override
    public Optional<Account> findByNickName(String nickName) {
        return delegate.findByNickName(nickName);
    }
}
