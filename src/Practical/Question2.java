/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Red King
 */
public class Question2 {

    private static final String LOCATION_NAME = "src\\TextFile\\";
    private static BufferedReader br = null;
    private static FileReader fr = null;

    public static TreeSet<String> getTextFileWords(String fileName) {
        TreeSet<String> words = new TreeSet<String>();
        try {
            String fullAddress = LOCATION_NAME + fileName;
            File file = new File(fullAddress);
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNextLine()) {
                String[] word = fileInput.nextLine().split(" ");
                for (int i = 0; i < word.length; i++) {
                    String inputWord = word[i].trim().replaceAll("[,.\"]", "")
                            .replaceAll("\\[|\\]", "")
                            .replaceAll("(\r|\n)", "");
                    if (inputWord != "" || inputWord != "\r" || inputWord != "\n") {
                        words.add(inputWord);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return words;
    }

    public static void main(String[] args) {
        TreeSet<String> list = getTextFileWords("FirstAuthor.txt");
        
        System.out.print(list);
    }
}
