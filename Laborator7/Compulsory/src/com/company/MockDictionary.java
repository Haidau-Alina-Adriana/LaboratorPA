package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MockDictionary implements Dictionary {

    public boolean isWord(String word) {
        try {
            String str;
            BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));
            while ((str = br.readLine()) != null) {
                if(str.equals(word)){
                    System.out.println(str);
                    return true;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return false;
    }

}