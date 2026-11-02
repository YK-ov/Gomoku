package LobbyAndChats;

import UsersAuthAndStatistics.Account;

import java.io.*;
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
        // TODO implement here
        return null;
    }

    /**
     * @param sender 
     * @param receiver 
     * @param text 
     * @return
     */
    public void whisper(Account sender, Account receiver, String text) {
        // TODO implement here

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