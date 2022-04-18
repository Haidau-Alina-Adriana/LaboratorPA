package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MockDictionary implements Dictionary {
    private final List<String> validWords;

    public MockDictionary(String filename) {
        this.validWords = new ArrayList<>();
        try {
            String str;
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((str = br.readLine()) != null) {
                validWords.add(str);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public synchronized boolean isWord(String word) {
        for (String validWord : validWords) {
            if (validWord.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public synchronized String createWordFromRandomLetters(String word) {
        String newWord = "";
        for (String validWord : validWords) {
            validWord = validWord.toLowerCase();
            boolean ok = true;
            for (int i = 0; i < word.length(); i++) {
                String letter = Character.toString(word.charAt(i));
                if (!validWord.contains(letter)) {
                    ok = false;
                    break;
                }
            }
            if (ok && word.length() >= validWord.length()) {
                return validWord;
            }
        }
        return newWord;
    }


}