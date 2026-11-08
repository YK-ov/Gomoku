package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.UsersAuthAndStatistics.Account;

/**
 * 
 */
public class PrivateChat extends Chat {

    /**
     * Default constructor
     */
    public PrivateChat() {
    }

    /**
     * 
     */
    private Account first;

    /**
     * 
     */
    private Account second;


    /**
     * @param first 
     * @param second
     */
    public PrivateChat(Account first, Account second) {
        this.first = first;
        this.second = second;
    }

    /**
     * @param a 
     * @param b 
     * @return
     */
    public boolean isBetween(Account a, Account b) {
        // TODO implement here
        return false;
    }

    /**
     * @param account 
     * @return
     */
    public boolean canAccountUseChat(Account account) {
        // TODO implement here
        return false;
    }

    /**
     * @param account 
     * @return
     */
    //public abstract boolean canAccountUseChat(Account account);

}