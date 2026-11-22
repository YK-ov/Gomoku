package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.GameCore.ColorType;
import com.example.gomoku.GameCore.MatchResult;
import com.example.gomoku.GameCore.Move;
import com.example.gomoku.Match.*;
import com.example.gomoku.UsersAuthAndStatistics.Account;
import com.example.gomoku.UsersAuthAndStatistics.User;
import com.example.gomoku.UsersAuthAndStatistics.UserActivity;

import java.time.Duration;
import java.util.List;

/**
 *
 */
public class MatchChat extends Chat implements MatchListener {
    private Match match;

    public MatchChat(Match match) {
        super();
        this.match = match;
    }

    @Override
    public void onMoveMade(Match match, Move move) {
        String color = null;

        if (move.getColor() == ColorType.White) {
            color = "Biały";
        }
        else {
            color = "Czarny";
        }

        Duration timeSpentOnAMove = match.getTimer().getTimerPerRound().minus(match.getTimeRemaining());
        long totalSeconds = timeSpentOnAMove.toSeconds();
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;

        String timeText;
        if (minutes == 0) {
            timeText = seconds + " s";
        }
        else {
            timeText = minutes + " min " + seconds + " s";
        }

        sendSystemMessage(color + " gracz wykonał ruch (X: " + move.getXCoordinate() + ", Y: " + move.getYCoordinate() + ") w ciągu " + timeText + ".");
    }

    @Override
    public void onStatusChanged(Match match, MatchStatus status) {
        if (status == MatchStatus.Paused){
            super.sendSystemMessage("Gra została wstrzymana");
        }

        if (status == MatchStatus.PausedByDisconnect){
            List<Player> players = match.getPlayersInMatch();

            for (Player player : players) {
                if (player.getClass() == HumanPlayer.class){
                    User user = ((HumanPlayer) player).getUser();

                    if (user.getActivity() == UserActivity.Offline){
                        super.sendSystemMessage("Gra została wstrzymana przez użytkownika");
                    }
                }
            }
        }

        if (status == MatchStatus.Aborted){
            super.sendSystemMessage("Gra została przerwana administratorem");
        }
    }

    @Override
    public void onMatchFinished(Match match, MatchResult result) {
        if (result == MatchResult.WhiteWon){
            super.sendSystemMessage("Wygrał gracz biały");
        }
        else if (result == MatchResult.BlackWon){
            super.sendSystemMessage("Wygrał gracz czarny");
        }
        else if (result == MatchResult.Draw){
            super.sendSystemMessage("Remis");
        }
//        else if (result == MatchResult.NoResult){
//            super.sendSystemMessage("Administrator przerwał grę, brak rezultatu partii");     -- zostawic albo ta wiadomosc albo w onMatchFinished()
//        }

        super.close();

    }

    @Override
    public boolean canAccountUseChat(Account account) {
        if (account.getClass().equals(User.class)){
            if (match.getPlayerByUser((User) account) != null){
                return true;
            }
        }

        return false;
    }

}