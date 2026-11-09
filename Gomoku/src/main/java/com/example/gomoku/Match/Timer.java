package com.example.gomoku.Match;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

import lombok.*;

@Getter
@Setter

/**
 * 
 */
public class Timer {

    /**
     * Default constructor
     */
    public Timer() {
    }

    /**
     * 
     */
    private Duration timerPerRound;

    /**
     * 
     */
    private Instant deadline;

    /**
     * 
     */
    private Duration remaining;

    /**
     * 
     */
    private boolean isRunning;


    /**
     * @param timePerRound
     */
    public Timer(Duration timePerRound) {
        this.timerPerRound = timePerRound;
    }

    /**
     * @return
     */
    public void start() {
        this.deadline = Instant.now().plus(timerPerRound);
        this.isRunning = true;

        //System.out.println(deadline);
    }
            // refresh function
    /**
     * @return
     */
    public void stop() {
        this.isRunning = false;
    }

    /**
     * @return
     */
    public boolean isExpired() {


        return false;
    }

    /**
     * 
     */
    public void resume() {
        // TODO implement here
    }

}