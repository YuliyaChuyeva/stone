package io.chueva.it.stone;

public class Game {

    public int generateComputerChoice(String[] artifacts) {
        return  (int) (Math.random() * artifacts.length);
    }

    public String playRound(int computerChoice, int playerChoiceIndex) {
        String result = "Win";
        int difChoice = Math.abs(computerChoice - playerChoiceIndex) % 2;
        int winnerMin = Math.min(computerChoice, playerChoiceIndex);
        int winnerMax = Math.max(computerChoice, playerChoiceIndex);

        switch (difChoice) {
            case 0:
                if (computerChoice == playerChoiceIndex) {
                    result = "You Draw";
                } else if (winnerMin == playerChoiceIndex) {
                    result = "You Win";
                } else {
                    result = "You Lose";
                }
                break;
            case 1:
                if (winnerMax == playerChoiceIndex) {
                    result = "You Win";
                } else {
                    result = " You Lose";
                }
                break;
        }

        return result;
    }
}
