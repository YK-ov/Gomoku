package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.UsersAuthAndStatistics.Account;

public class PrivateChat extends Chat {
    private Account first;

    private Account second;

    public PrivateChat(Account first, Account second) {
        super();
        this.first = first;
        this.second = second;
    }

    public boolean isBetween(Account a, Account b) {
        if ((first.equals(a) && second.equals(b)) || (first.equals(b) && second.equals(a))) {
            return true;
        }

        return false;
    }

    public boolean canAccountUseChat(Account account) {
        if (account.equals(first) || account.equals(second)) {
            return true;
        }

        return false;
    }

}