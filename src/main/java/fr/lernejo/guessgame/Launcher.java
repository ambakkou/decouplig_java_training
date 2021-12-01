package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextLong(100); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
        // long random Number = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
        //System.out.println(randomNumber);
        Player player = new HumanPlayer();
        Simulation sim = new Simulation(player);
        sim.initialize(randomNumber);
        sim.loopUntilPlayerSucceed();
    }
}
