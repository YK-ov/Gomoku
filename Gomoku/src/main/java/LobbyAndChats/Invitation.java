package LobbyAndChats;

import UsersAuthAndStatistics.User;

import java.io.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 
 */
public class Invitation {

    /**
     * Default constructor
     */
    public Invitation() {
    }

    /**
     * 
     */
    private User inviter;

    /**
     * 
     */
    private User invitee;

    /**
     * 
     */
    private InviteStatus status;

    /**
     * 
     */
    private LocalDateTime expiresAt;

    /**
     * @return
     */
    public Group accept() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void decline() {
        // TODO implement here

    }

    /**
     * @return
     */
    public boolean isExpired() {
        // TODO implement here
        return false;
    }

    /**
     * @param inviter 
     * @param invitee
     */
    public Invitation(User inviter, User invitee) {
        this.inviter = inviter;
        this.invitee = invitee;

        this.status = InviteStatus.Pending;
        this.expiresAt = LocalDateTime.now().plusSeconds(45);
    }

}