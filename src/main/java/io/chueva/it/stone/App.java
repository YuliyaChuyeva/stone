package io.chueva.it.stone;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.lang.System.in;

public class App {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        if (args.length < 3 || args.length % 2 == 0) {
            System.out.println("Please enter arguments >=3 and odd quantity.For example: Rock, Paper, Scissors, Lizard, Spock");
            System.exit(0);
        }

        CryptoManager crypto = new CryptoManager();
        Game game = new Game();
        OutputRender outputRender = new OutputRender();

        String key = crypto.generateKey();

        int ComputerChoiceIndex = game.generateComputerChoice(args);
        String computer = args[ComputerChoiceIndex];
        int computerChoice = ComputerChoiceIndex + 1;

        String hmac = crypto.generateMac(key, computer);
        System.out.println("HMAC : " + hmac);
        outputRender.showRules(args);
        System.out.println("Please choose your variant");

        Scanner sc = new Scanner(System.in);
        String playerChoice = sc.nextLine();
        if(playerChoice.equals("?")){
         outputRender.showResults();}
        else if(playerChoice.equals("0")){
            System.out.println("Thanks for playing!");
            System.exit(0);}
        else {
            try {
                int playerChoiceIndex = Integer.parseInt(playerChoice);
                String message= "Your move :" + args[playerChoiceIndex-1 ];
                if(playerChoiceIndex == 1){
                    System.out.println(message);
                }
                else if(playerChoiceIndex == 2){
                    System.out.println(message);
                }
                else if(playerChoiceIndex == 3){
                    System.out.println(message);
                }
                else if(playerChoiceIndex == 4){
                    System.out.println(message);
                }
                else if(playerChoiceIndex == 5){
                    System.out.println(message);
                }
                System.out.println("Computer move: " + computer);
                String roundResult = game.playRound(computerChoice, playerChoiceIndex);
                System.out.println(roundResult);
                System.out.println("HMAC key :" + key);
            } catch (NumberFormatException e){
                System.out.println("incorrect");
            }
}

    }
}
