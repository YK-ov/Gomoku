package Match;

import AI.Difficulty;
import GameCore.ColorType;
import GameCore.MatchResult;
import UsersAuthAndStatistics.User;

import java.time.Duration;

/**
 * 
 */
public class ComputerMatch extends Match {

    /**
     * Default constructor
     */
    public ComputerMatch() {
    }

    /**
     * @param timePerRound 
     * @param isRated 
     * @param user 
     * @param userColor 
     * @param computerColor 
     * @param difficulty 
     * @param sM
     */
    public ComputerMatch(Duration timePerRound, boolean isRated, User user, ColorType userColor, ColorType computerColor, Difficulty difficulty, SpectateManager sM) {
        super(timePerRound, isRated, sM);

        HumanPlayer humanPlayer = new HumanPlayer(userColor, user);
        addPlayer(humanPlayer);

        ComputerPlayer computerPlayer = new ComputerPlayer(computerColor, difficulty);
        addPlayer(computerPlayer);
    }

    /**
     * @param result 
     * @return
     */
    //@Override
    protected int applyRatings(MatchResult result) {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    protected void afterMove() {
        // TODO implement here

    }

    /**
     * @param result 
     * @return
     */
    //protected abstract int applyRatings(MatchResult result);

    /**
     * @return
     */
    //protected abstract void afterMove();

}