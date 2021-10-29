package io.chueva.it.stone;

public class Game {

    public int generateComputerChoice(String[] artifacts) {
        return  (int) (Math.random() * artifacts.length);
    }

    public String playRound(int computerChoice, int playerChoice) {
        String result = "Win";
        int difChoice = Math.abs(computerChoice - playerChoice) % 2;
        int winnerMin = Math.min(computerChoice, playerChoice);
        int winnerMax = Math.max(computerChoice, playerChoice);

        switch (difChoice) {
            case 0:
                if (computerChoice == playerChoice) {
                    result = "Draw";
                } else if (winnerMin == playerChoice) {
                    result = "Win";
                } else {
                    result = "Lose";
                }
                break;
            case 1:
                if (winnerMax == playerChoice) {
                    result = "Win";
                } else {
                    result = "Lose";
                }
                break;
        }

        return result;
    }
}
