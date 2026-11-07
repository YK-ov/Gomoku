package UsersAuthAndStatistics;

import java.io.*;
import java.util.*;

/**
 * 
 */
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
        return true; // admin nie moze zostac bana
    }

    /**
     * @return
     */
    //public abstract boolean canLogin();

}