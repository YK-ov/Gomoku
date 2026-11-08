package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.UsersAuthAndStatistics.Account;

import java.time.LocalDateTime;

/**
 * 
 */
public class Message {

    /**
     * Default constructor
     */
    public Message() {
    }

    /**
     * 
     */
    private Account sender;

    /**
     * 
     */
    private String text;

    /**
     * 
     */
    private LocalDateTime sentAt;


    /**
     * @param sender 
     * @param text 
     * @param sentAt
     */
    public Message(Account sender, String text, LocalDateTime sentAt) {
        this.sender = sender;
        this.text = text;
        this.sentAt = sentAt;
    }

}