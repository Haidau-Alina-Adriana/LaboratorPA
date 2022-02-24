package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Main lab1 = new Main(); 
        lab1.compulsory();
        if (args.length < 3) {
            System.out.println("Usage: number, number, one or more characters");
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
        for (int i = 0; i < m; i++) {
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
                    if (foundCommonLetter(words[i], words[j]) != -1) {
                        adjacencyMatrix[i][j] = true;
                    } else {
                        adjacencyMatrix[i][j] = false;
                    }
                }
            }
        }

        String[][] neighbour = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j]) {
                    neighbour[i][j] = words[j];
                } else {
                    neighbour[i][j] = "";
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
                    System.out.print(neighbour[i][j] + " ");
                }
                System.out.println();
            }

        }
    }

    int foundCommonLetter(String wordOne, String wordTwo) {
        for (int i = 0, len = wordOne.length(); i < len; i++) {
            char l = wordOne.charAt(i);
            String letter = Character.toString(l);
            if (wordTwo.contains(letter)) {
                return 1;
            }
        }
        return -1;
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
