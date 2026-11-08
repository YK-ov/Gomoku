package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.UsersAuthAndStatistics.Account;

import java.util.*;

/**
 * 
 */
public abstract class Chat {

    /**
     * Default constructor
     */
    public Chat() {
        this.messages = new ArrayList<>();
    }

    /**
     * 
     */
    private List<Message> messages;

    /**
     * 
     */
    private boolean isOpen;


    /**
     * @param sender 
     * @param text 
     * @return
     */
    public void send(Account sender, String text) {
        // TODO implement here

    }

    /**
     * @param account 
     * @return
     */
    public abstract boolean canAccountUseChat(Account account);

    /**
     * @return
     */
    public void close() {
        // TODO implement here

    }

}