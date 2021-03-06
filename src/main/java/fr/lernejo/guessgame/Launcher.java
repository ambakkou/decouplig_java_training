package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("launcher");
        
        if(args.length == 1 && args[0].equals("-interactive")){
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextLong(100);
            Player player = new HumanPlayer();
            Simulation sim = new Simulation(player);
            sim.initialize(randomNumber);
            sim.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }
        else if(args.length == 2 && (args[0].equals("-auto") && args[1].matches("[0-9]+"))){
            Player player = new ComputerPlayer();
            Simulation sim = new Simulation(player);
            sim.initialize(Long.parseLong(args[1]));
            sim.loopUntilPlayerSucceed(1000);
        }
        else {
            logger.log("Argument  -interactive pour jouer, -auto [0-9] pour lancer le bot");
        }
    }
}
