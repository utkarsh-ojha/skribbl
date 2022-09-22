package com.scribbl.chatserver.services.impl;

import com.scribbl.chatserver.services.WordGuessGameService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class WordGuessGameImpl implements WordGuessGameService {

    private String randomWord;

    @Override
    public String pickRandomWord() {
        Random random = new Random();
        String[] words = {"Airplane", "Ears", "Piano", "Angry", "Elephant", "Pinch", "Baby", "Fish", "Reach", "Ball", "Flick", "Remote", "Baseball", "Football", "Roll", "Basketball", "Fork", "Sad", "Bounce", "Giggle", "Scissors", "Cat", "Golf", "Skip", "Chicken", "Guitar", "Sneeze", "Chimpanzee", "Hammer", "Spin", "Clap"}; // array of animals
        randomWord = words[random.nextInt(words.length)]; // prints the random word from above list
        return randomWord;
    }

    @Override
    public boolean checkTheGuessedWord(String guessedWord) {
        if (guessedWord.trim().equals(randomWord))
            return true;
        return false;
    }
}
