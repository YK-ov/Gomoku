package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.GameCore.MatchResult;
import com.example.gomoku.GameCore.Move;
import com.example.gomoku.Match.Match;
import com.example.gomoku.UsersAuthAndStatistics.Account;
import com.example.gomoku.Match.MatchStatus;
import com.example.gomoku.Match.MatchListener;
import com.example.gomoku.UsersAuthAndStatistics.User;
import com.example.gomoku.UsersAuthAndStatistics.UserActivity;

import java.util.*;

public class Lobby implements MatchListener {
    private List<Match> activeMatches;

    private Map<String, MatchChat> matchChats;

    private LobbyChat lobbyChat;

    private ActiveAccountsBoard activeAccountsBoard;

    public Lobby() {
        this.activeMatches = new ArrayList<>();
        this.lobbyChat = new LobbyChat();
        this.activeAccountsBoard = new ActiveAccountsBoard();

        this.matchChats = new HashMap<>();
    }

    public void join(Account account) {
        if (account.getClass() == User.class) {
            ((User) account).setActivity(UserActivity.InLobby);
        }
    }

    public void leave(Account account) {
        if (account.getClass() == User.class) {
            ((User) account).setActivity(UserActivity.Offline);
        }
    }

    public void onMoveMade(Match match, Move move) {
        // TODO implement here

    }

    public void onStatusChanged(Match match, MatchStatus status) {
        // TODO implement here

    }

    public void onMatchFinished(Match match, MatchResult result) {
        // TODO implement here

    }

    public MatchChat registerMatch(Match match) {
        // TODO implement here
        return null;
    }

    public void unregisterMatch(Match match) {
        // TODO implement here

    }

}