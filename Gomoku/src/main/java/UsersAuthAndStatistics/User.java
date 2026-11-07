package UsersAuthAndStatistics;

import java.io.*;
import java.util.*;

/**
 * 
 */
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

    public UserState getState() {
        return state;
    }

    public UserActivity getActivity() {
        return activity;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public void setActivity(UserActivity activity) {
        this.activity = activity;
    }
}