package UsersAuthAndStatistics;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class User extends Account {

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * 
     */
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
        // TODO implement here

    }

    /**
     * @return
     */
    public boolean canLogin() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    //public abstract boolean canLogin();

}