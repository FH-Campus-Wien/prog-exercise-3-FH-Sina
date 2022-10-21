package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        oneMonthCalendar(28, 2);
        lcg(45345);
        guessingGame(randomNumberBetweenOneAndHundred());
        int Array1[] = new int[]{3, 7, 9};
        int Array2[] = new int[]{5, 8, 9};
        camelCase("AnY noise annoYs an oYster but a noisY noise annoYs an oYster more.");
        int Zahl[] = new int[]{5, 8, 3, 2, 4};
        checkDigit(Zahl);
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
    }

    public static void oneMonthCalendar(int MonthDays, int firstDay) {

        boolean InSevenDays = false;
        for (int i = 1; i < firstDay; i++) {
            System.out.print("   ");
        }

        for(int i = 1; i < MonthDays + 1; i++) {

            if (i < 10) {
                System.out.print(" " + i + " ");
            }
            else {
                System.out.print(i + " ");
                InSevenDays = true;
            }
            if (((firstDay - 1) + i) % 7 == 0) {
                System.out.println();
                InSevenDays = false;
            }
        }
        if (InSevenDays) {
            System.out.println("");
        }
    }

    public static long[] lcg(long Seed) {
        long c = 12345;
        long a = 1103515245;
        long m = (long) Math.pow(2, 31); //2^31

        long[] Number = new long[10 + 1];
        Number[0] = Seed;

        for (int i = 0; i < 10; i++) {
            Number[i + 1] = (a * Number[i] + c) % m;
        }
        return Arrays.copyOfRange(Number, 1, Number.length);
    }

    public static void guessingGame(int numberToGuess) {
        int GuessNumber;
        Scanner s = new Scanner(System.in);
        for (int i = 1; i < 11; i++) {
            System.out.print("Guess number " + i + ":");
            GuessNumber = s.nextInt();

            if (GuessNumber == numberToGuess) {
                System.out.println(" You won wisenheimer!");
                break;
            } else if (i == 10) {
                System.out.println(" You lost! Have you ever heard of divide & conquer?");
                break;
            } else if (GuessNumber > numberToGuess) {
                System.out.println(" The number AI picked is lower than your guess.");
            } else {
                System.out.println(" The number AI picked is higher than your guess.");
            }
        }
    }
        public static int randomNumberBetweenOneAndHundred () {
            int minimum = 1;
            int maximum = 100;
            int RandomNumber = (int) (Math.random() * (maximum - minimum)) + 1;
            return RandomNumber;
        }
    public static boolean swapArrays(int[] Array1, int[] Array2){
        if(Array1.length != Array2.length){
            return false;
        } else{
            for(int i = 0; i < Array1.length; i++){
                Array1[i] = Array1[i] - Array2[i];
                Array2[i] = Array2[i] + Array1[i];
                Array1[i] = Array2[i] - Array1[i];
            }
        } return true;
    }
    public static String camelCase(String Sentence) {
        char[] letters = Sentence.toCharArray();

        if (letters[0] >= 97 && letters[0] <= 122) {
            letters[0] -= 32;
        }
        for (int i = 0; i < letters.length; i++) {
            if (i >= 1 && letters[i - 1] != ' ' && letters[i] >= 65 && letters[i] <= 90) {
                letters[i] += 32;
            }
            if (i >= 1 && letters[i - 1] == ' ' && letters[i] >= 97 && letters[i] <= 122) {
                letters[i] -= 32;
            }
        }

        for (int i = 0; i < letters.length; i++) {
            if ((letters[i] > 0 && letters[i] <= 64) || (letters[i] >= 91 && letters[i] <= 96) || (letters[i] >= 123 && letters[i] <= 127)) {
                letters[i] = 32;
            }
        }
        String WithoutSpace = String.valueOf(letters).replace(" ", "");
        return WithoutSpace;
    }
    public static int checkDigit(int[] Zahl) {
        int summe = 0;

        for(int x = 0; x < Zahl.length;x++) {
            Zahl[x] = Zahl[x] * (x+2);
            summe = summe + Zahl[x];
        }

        int rest = summe % 11;
        int Pruefziffer = 11-rest;

        if(Pruefziffer == 10) {
            Pruefziffer = 0;
        }
        else if(Pruefziffer == 11) {
            Pruefziffer = 5;
        }
        return Pruefziffer;
    }
}