package UsersAuthAndStatistics;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class AuthManager {

    /**
     * Default constructor
     */
    public AuthManager() {
    }

    /**
     * @param nickName 
     * @param plainPassword 
     * @return
     */
    public boolean login(String nickName, String plainPassword) {
        // TODO implement here
        return false;
    }

    /**
     * @param nickName 
     * @param plainPassword 
     * @return
     */
    public User register(String nickName, String plainPassword) {
        // TODO implement here
        return null;
    }

    /**
     * @param nickName 
     * @return
     */
    public Account findAccountByNickName(String nickName) {
        // TODO implement here
        return null;
    }

    /**
     * @param account 
     * @param plainPassword 
     * @return
     */
    private boolean verifyPassword(Account account, String plainPassword) {
        // TODO implement here
        return false;
    }

    /**
     * @param plainPassword 
     * @return
     */
    private String hashPassword(String plainPassword) {
        // TODO implement here
        return "";
    }

    /**
     * @param oldPlainPassword 
     * @param newPlainPassword 
     * @param account 
     * @return
     */
    public boolean changePassword(String oldPlainPassword, String newPlainPassword, Account account) {
        // TODO implement here
        return false;
    }

    /**
     * @param oldNickName 
     * @param newNickName 
     * @return
     */
    public boolean changeNickName(String oldNickName, String newNickName) {
        // TODO implement here
        return false;
    }

}