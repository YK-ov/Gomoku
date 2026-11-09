package com.example.gomoku.UsersAuthAndStatistics;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 */
public class AuthManager {
    private PasswordEncoder passwordEncoder;    // szczegol implementacyjny springboota do hashowania
    private AuthenticationManager authenticationManager;    // szczegol implementacyjny springboota do zarzadzania autentykacja

    public AuthManager(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
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

    private boolean verifyPassword(Account account, String plainPassword) {
        if (passwordEncoder.matches(plainPassword, account.getHashedPassword())){
            return true;
        }

        return false;
    }

    /**
     * @param plainPassword 
     * @return
     */
    private String hashPassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

    /**
     * @param oldPlainPassword 
     * @param newPlainPassword 
     * @param account 
     * @return
     */
    public boolean changePassword(String oldPlainPassword, String newPlainPassword, Account account) {
        if (passwordEncoder.matches(oldPlainPassword, account.getHashedPassword())){
            account.setHashedPassword(hashPassword(newPlainPassword));

            return true;
        }

        return false;
    }

    /**
     * @param oldNickName 
     * @param newNickName 
     * @return
     */
    public boolean changeNickName(String oldNickName, String newNickName, Account account) {
        if (newNickName == null || newNickName.length() < 3 || newNickName.isBlank() || newNickName.length() > 8){
            return false;
        }

        if (account.getNickName().equals(newNickName)){
            return false;
        }

        account.setNickName(newNickName);

        return true;
    }

}