package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MockDictionary implements Dictionary {

    public synchronized boolean isWord(String word) {
        try {
            String str;
            BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));
            while ((str = br.readLine()) != null) {
                if (str.equals(word)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public synchronized String createWordFromRandomLetters(String word) {
        String newWord = "";
        try {
            String str;
            BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));
            while ((str = br.readLine()) != null) {
                str = str.toLowerCase();
                boolean ok = true;
                for (int i = 0; i < word.length(); i++) {
                    String letter = Character.toString(word.charAt(i));
                    if (!str.contains(letter)) {
                        ok = false;
                        break;
                    }
                }
                if (ok && word.length() >= str.length()) {
                    return str;
                }

            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return newWord;
    }


}