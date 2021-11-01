package io.chueva.it.stone;

import com.github.freva.asciitable.AsciiTable;

public class OutputRender {

    public void showRules(String[] artifacts) {
        System.out.println("Available moves:");
        for (int i = 0; i <= artifacts.length - 1; i++) {
            System.out.println(i +1  + " - " + artifacts[i]);
        }
        System.out.println("0 - exit");
        System.out.println("? - help");
    }

    public void showResults() {
        String[] headers = {"PC/ USER", "Rock", "Paper", "Scissors", " Spock", "Lizard"};
        String[][] data = {
                {"Rock", "DRAW", "WIN", "LOSE", "WIN", "LOSE"},
                {"Paper", "LOSE", "DRAW", "WIN", "LOSE", "WIN"},
                {"Scissors", "WIN", "LOSE", "DRAW", "WIN", "LOSE"},
                {"Spock", "LOSE", "WIN", "LOSE", "DRAW", "WIN"},
                {"Lizard","WIN","LOSE","WIN", "LOSE","DRAW"}
        };

        System.out.println(AsciiTable.getTable(headers, data));
    }
}
