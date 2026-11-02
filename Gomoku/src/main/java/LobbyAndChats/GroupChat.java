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
        this.members = new ArrayList<>();
    }

    /**
     * @param account
     */
    public void addMember(Account account) {
        members.add(account);
    }

    /**
     * @param account
     */
    public void removeMember(Account account) {
        members.remove(account);
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