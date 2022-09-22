package com.scribbl.chatserver.controller;

import com.scribbl.chatserver.services.impl.WordGuessGameImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordGuessGameController {

    @Autowired
    private WordGuessGameImpl wordGuessGame;

    private String randomWord;

    @GetMapping("wordguessgame/newword")
    public String newRandomWordSelector() {
        randomWord = wordGuessGame.pickRandomWord();
        return randomWord;
    }

    @GetMapping("wordguessgame/checkGuessedWord")
    public boolean checkGuessedWordByPlayer(@RequestBody String guessedWord) {
        return wordGuessGame.checkTheGuessedWord(guessedWord);
    }

}
