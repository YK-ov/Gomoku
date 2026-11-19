package com.example.gomoku.Match;

import com.example.gomoku.UsersAuthAndStatistics.User;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * 
 */
public class Queue {
    private LinkedHashMap<User, Instant> currentlyInQueue;

    public Queue() {
        this.currentlyInQueue= new LinkedHashMap<>();
    }

    public int getSize(){
        return currentlyInQueue.size();
    }

    public void addUser(User user) {
        currentlyInQueue.put(user, Instant.now());
    }

    public void removeUser(User user) {
        currentlyInQueue.remove(user);
    }

    public boolean contains(User user) {
        if (currentlyInQueue.containsKey(user)) {
            return true;
        }

        return false;
    }

    public LinkedHashMap<User, Instant> getAll() {
        return currentlyInQueue;
    }

//    public User getUser(int index) {
//        return currentlyInQueue.get()
//    }

}