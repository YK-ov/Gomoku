package LobbyAndChats;

import UsersAuthAndStatistics.Account;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class GroupChat extends Chat {

//    /**
//     * Default constructor
//     */
//    public GroupChat() {
//    }
//
//    /**
//     *
//     */
    private List<Account> members;


    /**
     * 
     */
    public GroupChat() {
        // TODO implement here
    }

    /**
     * @param account
     */
    public void addMember(Account account) {
        // TODO implement here
    }

    /**
     * @param account
     */
    public void removeMember(Account account) {
        // TODO implement here
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