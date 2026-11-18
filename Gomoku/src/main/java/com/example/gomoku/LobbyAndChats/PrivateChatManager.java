package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.UsersAuthAndStatistics.Account;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */
public class PrivateChatManager {

//    /**
//     * Default constructor
//     */
//    public PrivateChatManager() {
//    }
//
//    /**
//     *
//     */
    private List<PrivateChat> privateChats;


    /**
     * 
     */
    public PrivateChatManager() {
        privateChats = new ArrayList<>();
    }

    /**
     * @param first 
     * @param second 
     * @return
     */
    public PrivateChat openOrGetChat(Account first, Account second) {
        return new PrivateChat(first, second);
    }

    /**
     * @param sender 
     * @param receiver 
     * @param text 
     * @return
     */
    public void whisper(Account sender, Account receiver, String text) {
        LocalDateTime now = LocalDateTime.now();
        Message message = new Message(sender, text, now);


    }

    /**
     * @param chat 
     * @return
     */
    public void closeChat(PrivateChat chat) {
        // TODO implement here

    }

    /**
     * @param account 
     * @return
     */
    public List<PrivateChat> getChatsOf(Account account) {
        // TODO implement here
        return null;
    }

}