package com.example.gomoku.UsersAuthAndStatistics;

import java.io.*;
import java.util.*;

import jakarta.persistence.*;
import lombok.*;

/**
 * 
 */
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

    /**
     * 
     */
    @Column(name = "hashed_password", nullable = false)
    private String hashedPassword;

    /**
     * 
     */
    @Id
    private String id;


    /**
     * @param nickName 
     * @param hashedPassword
     */
    public Account(String nickName, String hashedPassword) {
        this.nickName = nickName;
        this.hashedPassword = hashedPassword;

        this.id = UUID.randomUUID().toString();
    }


    /**
     * @return
     */
    public abstract boolean canLogin();

}