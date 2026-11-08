package com.example.gomoku.repositories.jpa;

import com.example.gomoku.UsersAuthAndStatistics.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountJpaRepository extends JpaRepository<Account, String> {
    Optional<Account> findByNickName(String nickName);
}
