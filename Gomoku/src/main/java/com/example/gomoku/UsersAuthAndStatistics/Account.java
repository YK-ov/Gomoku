package com.example.gomoku.UsersAuthAndStatistics;

import java.io.*;
import java.util.*;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "hashedPassword")

@Entity
@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_role", discriminatorType = DiscriminatorType.STRING)
public abstract class Account {
    @Column(name = "nick_name", unique = true, nullable = false)
    private String nickName;

    @Column(name = "hashed_password", nullable = false)
    private String hashedPassword;

    @Id
    private String id;

    public Account(String nickName, String hashedPassword) {
        this.nickName = nickName;
        this.hashedPassword = hashedPassword;

        this.id = UUID.randomUUID().toString();
    }

    public abstract boolean canLogin();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}