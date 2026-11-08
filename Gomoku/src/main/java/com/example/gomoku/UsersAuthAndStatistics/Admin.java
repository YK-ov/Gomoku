package com.example.gomoku.UsersAuthAndStatistics;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 */

@AllArgsConstructor
@Getter
@Setter

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Account {
    public Admin(String nickName, String hashedPassword) {
        super(nickName, hashedPassword);
    }
    /**
     * @param user 
     * @return
     */
    public void banUser(User user) {
        if (user.getState() == UserState.Active) {
            user.setState(UserState.Banned);
        }

    }

    /**
     * @param user 
     * @return
     */
    public void unbanUser(User user) {
        if (user.getState() == UserState.Banned){
            user.setState(UserState.Active);
        }

    }

    /**
     * @return
     */
    public boolean canLogin() {
        return true; // admin nie moze dostac bana
    }

    /**
     * @return
     */
    //public abstract boolean canLogin();

}