package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;


public class ComputerPlayer implements Player{
    Logger logger = LoggerFactory.getLogger("player");
    long min = Long.MIN_VALUE;
    long max = Long.MAX_VALUE;
    @Override
    public long askNextGuess() {
        return (max + min)/2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater){
            logger.log("plus grand");
            min = (max + min)/2;
        }
        else{
            logger.log("plus petit");
            max = (max + min)/2;
        }

    }
}
