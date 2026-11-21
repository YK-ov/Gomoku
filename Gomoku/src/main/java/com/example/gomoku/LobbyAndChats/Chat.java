package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.UsersAuthAndStatistics.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.access.AccessDeniedException;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */

public abstract class Chat {
    public Chat() {
        this.messages = new ArrayList<>();
        isOpen = true;
    }

    private List<Message> messages;

    private boolean isOpen;

    public synchronized Message send(Account sender, String text){
        if (!isOpen) {
            throw new IllegalStateException("Czat jest zamknięty");
        }

        if (!canAccountUseChat(sender)) {
            throw new AccessDeniedException("Brak dostępu do czatu");
        }

        if (text == null || text.isBlank()){
            throw new IllegalArgumentException("Wiadomość jest pusta");
        }

        if (text.length() > 150){
            throw new IllegalArgumentException("Wiadomość jest zbyt długa");
        }

        Message message = new Message(sender, text, LocalDateTime.now());

        messages.add(message);

        return message;
    }

    public abstract boolean canAccountUseChat(Account account);

    public void close() {
        isOpen = false;
    }

    public synchronized List<Message> getMessages() {
        return messages;
    }


}