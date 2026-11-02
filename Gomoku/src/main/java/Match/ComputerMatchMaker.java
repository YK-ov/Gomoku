package Match;

import AI.Difficulty;
import GameCore.ColorType;
import UsersAuthAndStatistics.User;

import java.io.*;
import java.time.Duration;
import java.util.*;

/**
 * 
 */
public class ComputerMatchMaker {

    /**
     * Default constructor
     */
    public ComputerMatchMaker() {
    }

    /**
     * 
     */
    private SpectateManager spectateManager;


    /**
     * @param spectateManager
     */
    public ComputerMatchMaker(SpectateManager spectateManager) {
        this.spectateManager = spectateManager;
    }

    /**
     * @param isRated 
     * @param user 
     * @param userColor 
     * @param difficulty 
     * @param sM 
     * @return
     */
    public ComputerMatch startComputerMatch(boolean isRated, User user, ColorType userColor, Difficulty difficulty, SpectateManager sM) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ColorType randomizeColor() {
        // TODO implement here
        return null;
    }

    /**
     * @param difficulty 
     * @return
     */
    public Duration timePerRoundFor(Difficulty difficulty) {
        // TODO implement here
        return null;
    }

}