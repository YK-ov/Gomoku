package LobbyAndChats;

import UsersAuthAndStatistics.Account;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

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