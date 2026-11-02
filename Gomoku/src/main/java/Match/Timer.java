package Match;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
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
        // TODO implement here
    }

    /**
     * @return
     */
    public void start() {
        // TODO implement here

    }

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

}