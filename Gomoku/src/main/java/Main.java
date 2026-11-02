import AI.*;
import GameCore.*;
import LobbyAndChats.*;
import Match.*;
import UsersAuthAndStatistics.*;

import java.time.Duration;

public class Main {
    public static void main(String[] args){
        Duration timePerRound = Duration.ofMinutes(3);
        Timer timer = new Timer(timePerRound);

        timer.start();

    }
}
