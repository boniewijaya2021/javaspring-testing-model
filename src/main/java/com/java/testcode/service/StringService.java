package com.java.testcode.service;

import org.springframework.stereotype.Service;

@Service
public class StringService {

    public String textdibalik(String input){
        StringBuilder result = new StringBuilder(input);
        return result.reverse().toString();

    }

    public String balikkataurutantetap(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(new StringBuilder(word).reverse().toString()).append(" ");
        }
        return result.toString().trim();
    }
}
