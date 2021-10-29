package io.chueva.it.stone;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.lang.System.in;

public class App {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        if (args.length < 3 || args.length % 2 == 0) {
            System.out.println("Please enter arguments >=3 and odd quantity.For example: Rock, Paper, Scissors, Lizard, Spock");
        }

        CryptoManager crypto = new CryptoManager();
        Game game = new Game();
        OutputRender outputRender = new OutputRender();

        String key = crypto.generateKey();

        outputRender.showRules(args);
        System.out.println("Please choose number");
        Scanner sc = new Scanner(in);
        int playerChoiceIndex = sc.nextInt();
        String playerChoice = args[playerChoiceIndex];

        int ComputerChoiceIndex = game.generateComputerChoice(args);
        String computer = args[ComputerChoiceIndex];
        int computerChoice = ComputerChoiceIndex + 1;

        String hmac = crypto.generateMac(key, computer);

        outputRender.showRoundChoices(args, playerChoiceIndex);
        String roundResult = game.playRound(computerChoice, playerChoiceIndex);

        System.out.println(String.format("Player: %s Computer: %s Result: %s hmac: %s key: %s",
                playerChoice, computer, roundResult, hmac, key));

        outputRender.showResults();
    }
}
