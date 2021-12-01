package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;



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
            player.respond(guess.compareTo(numberToGuess) <= 0);
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long max) {
        //TODO implement me
        logger.log("Début de la partie !");
        long debut = System.currentTimeMillis();
        boolean guess = nextRound();
        long cpt = 0;
        while (!guess && cpt<max){
            guess = nextRound();
            cpt++;
        }
        long fin = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(fin-debut);
        logger.log(new SimpleDateFormat("mm:ss.SSS").format(timestamp));
        if(guess)
            logger.log("Résultat trouvé en " + cpt + " itérations");
        else
            logger.log("Résultat non trouvé à la suite de " + cpt + " itérations");
    }
}
