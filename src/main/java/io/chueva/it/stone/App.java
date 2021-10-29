package io.chueva.it.stone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.lang.System.in;

public class App {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        //генерация ключа
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] values = new byte[16]; // 128 bit
        random.nextBytes(values);

        StringBuilder sb = new StringBuilder();
        for (byte b : values) {
            sb.append(String.format("%02x", b));
        }
        String key = sb.toString();



        if (args.length < 3 || args.length % 2 == 0) {
            System.out.println("Please enter arguments >=3 and odd quantity.For example: Rock, Paper, Scissors, Lizard, Spock");
        }
        // ход компа
        int indexComputerChoice = (int) (Math.random() * args.length);
        String computer = args[indexComputerChoice];
       int computerChoice = indexComputerChoice + 1;


       //вычислить HMAC
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);

        byte[] bytes = mac.doFinal(computer.getBytes(StandardCharsets.UTF_8));
        String hmac = new BigInteger(1, bytes).toString(16);
        System.out.println("HMAC: " + hmac);// write your code here

        //таблица
        System.out.println("Available moves:");
            for(int i = 0; i <= args.length-1; i++){
                System.out.println(i+1 + " - " + args[i]);
            }
        System.out.println("0 - exit");
        System.out.println("? - help");

        // получить ход пользователя
        System.out.println("Please choose number");
        Scanner sc = new Scanner(in);
        int myChoice = sc.nextInt();

        switch (myChoice){
            case 1 :
                System.out.println("Your move :" + args[myChoice-1]); break;
            case 2:System.out.println("Your move :" + args[myChoice-1]); break;
            case 3: System.out.println("Your move :" + args[myChoice-1]); break;
            case 4:System.out.println("Your move :" + args[myChoice-1]); break;
            case 5:System.out.println("Your move :" + args[myChoice-1]); break;
            case 0: return;
            //case '?': + метод на таблицу
            default:System.out.println();
        }

        System.out.println("Computer move: " + computer);

// правила игры

        int difChoice = Math.abs(computerChoice-myChoice)%2;
        int winnerMin = Math.min(computerChoice,myChoice);
        int winnerMax = Math.max(computerChoice,myChoice);

        switch (difChoice){
            case 0:
                if(computerChoice == myChoice){
                System.out.println(" Draw!!!");
                }
               else if(winnerMin == myChoice){
                System.out.println("You win!");}
                else System.out.println("You lose!");break;

            case 1:
               if (winnerMax == myChoice){
                   System.out.println("You win!");
               }
               else System.out.println("You lose!");break;
        }

        System.out.println("HMAC key: " + key);

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


    }
}
