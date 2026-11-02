package UsersAuthAndStatistics;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Admin extends Account {

    /**
     * Default constructor
     */
    public Admin() {
    }

    /**
     * @param nickName 
     * @param hashedPassword
     */
    public Admin(String nickName, String hashedPassword) {
        super(nickName, hashedPassword);
    }

    /**
     * @param user 
     * @return
     */
    public void banUser(User user) {
        // TODO implement here

    }

    /**
     * @param user 
     * @return
     */
    public void unbanUser(User user) {
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