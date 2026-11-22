package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.UsersAuthAndStatistics.Account;
import com.example.gomoku.UsersAuthAndStatistics.User;
import com.example.gomoku.UsersAuthAndStatistics.UserActivity;

public class LobbyChat extends Chat {
    public LobbyChat() {
        super();
    }

    @Override
    public boolean canAccountUseChat(Account account) {
        if (!account.canLogin()){
            return false;
        }

        if (account.getClass() == User.class) {
            if (((User) account).getActivity() != UserActivity.InMatch){
                return false;
            }
        }

        return true;
    }
}