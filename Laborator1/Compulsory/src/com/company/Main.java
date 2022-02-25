package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Main lab1 = new Main();
        lab1.compulsory();
        if (args.length < 3) { //check if there are at least 3 arguments
            System.out.println("Usage: number, number, one or more characters");
            System.exit(-1);
        } else if (!lab1.isPositiveAndNumeric(args[0]) || !lab1.isPositiveAndNumeric(args[1])) { //if the first 2 arguments are numbers
            System.out.println("Only positive numbers");
            System.exit(-1);
        }
        lab1.homework(args);
        lab1.bonus();
    }

    void compulsory() {
        System.out.println("Hello World!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n *= 3;
        n += 0b10101 + 0xFF;
        n *= 6;
        int result = 0;
        while (n > 0 || result > 9) {
            if (n == 0) {
                n = result;
                result = 0;
            }
            while (n != 0) {
                result += n % 10;
                n /= 10;
            }
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

    void homework(String[] args) {
        long startTime = System.nanoTime();
        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        int m = args.length - 2;
        char[] alphabet = new char[m];
        for (int i = 0; i < m; i++) { //take the rest of the arguments
            alphabet[i] = args[i + 2].charAt(0);
        }

        String[] words = new String[n];
        if (n > 30_000) {
            for (int i = 0; i < n; i++) {
                words[i] = createRandWord(alphabet, p);
            }
        } else {
            System.out.print("Words array: ");
            for (int i = 0; i < n; i++) {
                words[i] = createRandWord(alphabet, p);
                System.out.print(words[i] + " ");
            }
            System.out.println();
        }

        boolean[][] adjacencyMatrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    adjacencyMatrix[i][j] = false;
                } else {
                    adjacencyMatrix[i][j] = foundCommonLetter(words[i], words[j]);
                }
            }
        }

        String[][] neighbours = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j]) {
                    neighbours[i][j] = words[j];
                } else {
                    neighbours[i][j] = "";
                }
            }
        }

        if (n > 30_000) {
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println("Running time of the application" + totalTime);
        } else {
            System.out.println("Neighbour array: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(neighbours[i][j] + " ");
                }
                System.out.println();
            }

        }
    }

    boolean isPositiveAndNumeric(String word) {
        if (word.charAt(0) == '-') {
            return false;
        } else {
            for (int i = 0, n = word.length(); i < n; i++) {
                if (!Character.isDigit(word.charAt(i)))
                    return false;
            }
        }
        return true;
    }

    boolean foundCommonLetter(String wordOne, String wordTwo) {
        for (int i = 0, len = wordOne.length(); i < len; i++) {
            char l = wordOne.charAt(i);
            String letter = Character.toString(l);
            if (wordTwo.contains(letter)) {
                return true;
            }
        }
        return false;
    }

    String createRandWord(char[] alphabet, int p) {
        StringBuilder word = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < p; i++) {
            int k = rand.nextInt(alphabet.length);
            word.append(alphabet[k]);
        }
        return word.toString();
    }

    void bonus() {
        System.out.println("Bonus not implemented yet");
    }
}
