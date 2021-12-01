package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;//TODO add variable type
    private Long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        Long guess = player.askNextGuess();
        if (guess.equals(numberToGuess)){
            logger.log("Nombre trouvé");
            return true;}
        else{
            if(guess.compareTo(numberToGuess)>0){
                player.respond(false);
                return false;
            }
            else {
                player.respond(true);
                return false;
            }

        }
    }

    public void loopUntilPlayerSucceed() {
        //TODO implement me
        logger.log("Début de la partie !");
        boolean guess = nextRound();
        while (!guess){
            guess = nextRound();
        }
    }
}
