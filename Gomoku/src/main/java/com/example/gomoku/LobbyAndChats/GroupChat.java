package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.UsersAuthAndStatistics.Account;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class GroupChat extends Chat {
    private List<Account> members;

    public GroupChat() {
        super();
        this.members = new CopyOnWriteArrayList<>();
    }

    public void addMember(Account account) {
        members.add(account);
    }

    public void removeMember(Account account) {
        members.remove(account);
    }

    @Override
    public boolean canAccountUseChat(Account account) {
        if (members.contains(account)) {
            return true;
        }

        return false;
    }


}