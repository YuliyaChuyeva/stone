package io.chueva.it.stone;

import com.github.freva.asciitable.AsciiTable;

public class OutputRender {

    public void showRules(String[] artifacts) {
        System.out.println("Available moves:");
        for (int i = 0; i <= artifacts.length - 1; i++) {
            System.out.println(i + 1 + " - " + artifacts[i]);
        }
        System.out.println("0 - exit");
        System.out.println("? - help");
    }

    public void showRoundChoices(String[] artifacts, int playerChoice) {
        switch (playerChoice) {
            case 1:
                System.out.println("Your move :" + artifacts[playerChoice - 1]);
                break;
            case 2:
                System.out.println("Your move :" + artifacts[playerChoice - 1]);
                break;
            case 3:
                System.out.println("Your move :" + artifacts[playerChoice - 1]);
                break;
            case 4:
                System.out.println("Your move :" + artifacts[playerChoice - 1]);
                break;
            case 5:
                System.out.println("Your move :" + artifacts[playerChoice - 1]);
                break;
            case 0:
                return;
            //case '?': + метод на таблицу
            default:
                System.out.println();
        }
    }

    public void showResults() {
        //ascii таблица
        String leftAlignFormat = "| %-15s | %-4d |%n";

        System.out.format("+-------------+--------+---------+----------+---------+-------+%n");
        System.out.format("| PC/ User    | Rock   |    Paper|  Scissors|    Spock| Lizard| %n");
        System.out.format("+-------------+--------+---------+----------+---------+-------+%n");
        System.out.format("| Rock        |  DRAW  |   WIN    |LOSE     |WIN      |LOSE   |%n");
        System.out.format("+-------------+--------+---------+----------+---------+-------+%n");
        System.out.format("| Paper       | LOSE   | DRAW    | WIN      |LOSE     |WIN    |%n");
        System.out.format("+-------------+--------+---------+----------+---------+-------+%n");
        System.out.format("| Scissors    |  WIN   |  LOSE   |DRAW      |WIN      |LOSE   |%n");
        System.out.format("+-------------+--------+---------+----------+---------+-------+%n");
        System.out.format("| Spock       | LOSE   |   WIN   |LOSE      |DRAW     |WIN    |%n");
        System.out.format("+-------------+--------+---------+----------+---------+-------+%n");
        System.out.format("| Lizard      |  WIN   |   LOSE  |WIN       |LOSE     |DRAW   |%n");
        System.out.format("+-------------+--------+---------+----------+---------+-------+%n");


        System.out.println(AsciiTable.BASIC_ASCII);
    }
}
