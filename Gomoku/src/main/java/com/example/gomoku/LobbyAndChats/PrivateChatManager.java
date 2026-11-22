package com.example.gomoku.LobbyAndChats;

import com.example.gomoku.UsersAuthAndStatistics.Account;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class PrivateChatManager {
    private List<PrivateChat> privateChats;

    public PrivateChatManager() {
        privateChats = new CopyOnWriteArrayList<>();
    }

    public synchronized PrivateChat openOrGetChat(Account first, Account second) {
        for (PrivateChat chat : privateChats) {
            if (chat.isBetween(first, second)) {
                return chat;
            }
        }

        PrivateChat chat = new PrivateChat(first, second);
        privateChats.add(chat);

        return chat;
    }

    public void whisper(Account sender, Account receiver, String text) {
        if (sender.equals(receiver)) {
            throw new IllegalArgumentException("Nie można szeptać do siebie");
        }

        PrivateChat chat = openOrGetChat(sender, receiver);

        chat.send(sender, text);
    }

    public synchronized void closeChat(PrivateChat chat) {
        chat.close();
        privateChats.remove(chat);
    }

    public List<PrivateChat> getChatsOf(Account account) {
        List<PrivateChat> chats = new ArrayList<>();

        for (PrivateChat privateChat : privateChats) {
            if (privateChat.canAccountUseChat(account)){
                chats.add(privateChat);
            }
        }

        return chats;
    }

}