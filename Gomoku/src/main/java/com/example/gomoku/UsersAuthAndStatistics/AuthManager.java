package com.example.gomoku.UsersAuthAndStatistics;

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
    public boolean login(String nickName, String plainPassword) {       // metody login i register sa cienkie, sama logika rejestracji i logowania w AuthManager z SpringSecurity
        if (nickName == null || nickName.length() < 3 || nickName.isBlank() || nickName.length() > 8){
            return false;
        }

        if (plainPassword == null || plainPassword.isBlank()){
            return false;
        }

        return true;
    }

    /**
     * @param nickName 
     * @param plainPassword 
     * @return
     */
    public User register(String nickName, String plainPassword) {
        if (nickName == null || nickName.length() < 3 || nickName.isBlank() || nickName.length() > 8){
            return null;
        }

        if (plainPassword == null || plainPassword.isBlank()){
            return null;
        }

        return new User(nickName, plainPassword);
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


        return false;
    }

    /**
     * @param plainPassword 
     * @return
     */
    private String hashPassword(String plainPassword) {
        return "";
    }

    /**
     * @param oldPlainPassword 
     * @param newPlainPassword 
     * @param account 
     * @return
     */
    public boolean changePassword(String oldPlainPassword, String newPlainPassword, Account account) {
        return false;
    }

    /**
     * @param oldNickName 
     * @param newNickName 
     * @return
     */
    public boolean changeNickName(String oldNickName, String newNickName) {

        return false;
    }

}