package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.UsersAuthAndStatistics.User;

import java.time.LocalDateTime;

public class Invitation {
    private User inviter;

    private User invitee;

    private InviteStatus status;

    private LocalDateTime expiresAt;

    public synchronized Group accept() {
        if (isExpired() || status != InviteStatus.Pending){
            throw new IllegalStateException("Takie zaproszenie do grupy nie istnieje");
        }

        status = InviteStatus.Accepted;

        return new Group(inviter, invitee);
    }

    public synchronized void decline() {
        status = InviteStatus.Declined;
    }

    public synchronized boolean isExpired() {
        if (status == InviteStatus.Pending && expiresAt.isBefore(LocalDateTime.now())){
            status = InviteStatus.Pending;
        }

        if (status == InviteStatus.Expired) {
            return true;
        }
        else {
            return false;
        }

    }

    public Invitation(User inviter, User invitee) {
        this.inviter = inviter;
        this.invitee = invitee;

        this.status = InviteStatus.Pending;
        this.expiresAt = LocalDateTime.now().plusSeconds(45);
    }

}