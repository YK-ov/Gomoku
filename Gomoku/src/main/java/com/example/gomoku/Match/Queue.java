package com.example.gomoku.Match;

import com.example.gomoku.UsersAuthAndStatistics.User;

import java.util.*;

/**
 * 
 */
public class Queue {

//    /**
//     * Default constructor
//     */
//    public Queue() {
//    }
//
//    /**
//     *
//     */
    private List<User> currentlyInQueue;

    public Queue() {
        this.currentlyInQueue = new ArrayList<>();
    }

    public int getSize(){
        return currentlyInQueue.size();
    }

    public void addUser(User user) {
        currentlyInQueue.add(user);
    }

    public void removeUser(User user) {
        currentlyInQueue.remove(user);
    }

    public boolean contains(User user) {
        if (currentlyInQueue.contains(user)) {
            return true;
        }

        return false;
    }

    public List<User> getAll() {
        return currentlyInQueue;
    }

    public User getUser(int index) {
        return currentlyInQueue.get(index);
    }

}