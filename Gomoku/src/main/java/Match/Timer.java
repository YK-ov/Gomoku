package Match;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

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

        //System.out.println(deadline);
    }
            // refresh function
    /**
     * @return
     */
    public void stop() {
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
     * 
     */
    public void resume() {
        // TODO implement here
    }

    public Duration getTimerPerRound() {
        return timerPerRound;
    }

    public Instant getDeadline() {
        return deadline;
    }

    public Duration getRemaining() {
        return remaining;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setTimerPerRound(Duration timerPerRound) {
        this.timerPerRound = timerPerRound;
    }

    public void setDeadline(Instant deadline) {
        this.deadline = deadline;
    }

    public void setRemaining(Duration remaining) {
        this.remaining = remaining;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

}