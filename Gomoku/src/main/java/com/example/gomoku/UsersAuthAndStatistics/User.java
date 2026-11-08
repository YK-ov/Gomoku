package com.example.gomoku.UsersAuthAndStatistics;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

/**
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@DiscriminatorValue("USER")
public class User extends Account {
    private UserState state;

    /**
     * 
     */
    private UserActivity activity;


    /**
     * @param nickName 
     * @param hashedPassword
     */
    public User(String nickName, String hashedPassword) {
        super(nickName, hashedPassword);

        this.activity = UserActivity.InLobby;
        this.state = UserState.Active;
    }

    /**
     * @param newActivity 
     * @return
     */
    public void updateActivity(UserActivity newActivity) {
        this.activity = newActivity;
    }

    /**
     * @return
     */
    public boolean canLogin() {
        if (state == UserState.Active){
            return true;
        }

        return false;
    }

    /**
     * @return
     */
    //public abstract boolean canLogin();
}