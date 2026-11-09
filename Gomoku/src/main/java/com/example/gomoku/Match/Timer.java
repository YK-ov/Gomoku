package com.example.gomoku.Match;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

import lombok.*;

public class Timer {
    public Timer() {
    }

    private Duration timerPerRound;
    private Instant deadline;
    private Duration remaining;
    private boolean isRunning;

    public Timer(Duration timePerRound) {
        this.timerPerRound = timePerRound;
    }

    public void start() {
        this.remaining = timerPerRound;
        this.deadline = Instant.now().plus(timerPerRound);
        this.isRunning = true;
    }

    public void stop() {
        this.isRunning = false;
    }

    public boolean isExpired() {
        if (Instant.now().isAfter(deadline)) {
            return true;
        }

        return false;
    }

    public Duration getRemaining() {
        if (!isRunning) {
            return remaining;
        }

        Duration left = Duration.between(Instant.now(), deadline);

        if (left.isNegative()) {
            return Duration.ZERO;
        }

        return left;
    }

    public void resume() {
        if (!isRunning && !remaining.isZero()){
            this.deadline = Instant.now().plus(remaining);
            this.isRunning = true;
        }
    }

    public Duration getTimerPerRound() {
        return timerPerRound;
    }

    public Instant getDeadline() {
        return deadline;
    }

    public boolean isRunning() {
        return isRunning;
    }
}