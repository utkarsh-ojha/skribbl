package com.scribbl.chatserver.controller;

import com.scribbl.chatserver.services.impl.WordGuessGameImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordGuessGameController {

    @Autowired
    private WordGuessGameImpl wordGuessGame;

    private String randomWord;
    private Integer score;

    @GetMapping("wordguessgame/newword")
    public String newRandomWordSelector() {
        randomWord = wordGuessGame.pickRandomWord();
        return randomWord;
    }

    @GetMapping("wordguessgame/calculateScore")
    public Integer checkGuessedWordByPlayer(@RequestBody String guessedWord) {
        boolean wordCheck = wordGuessGame.checkTheGuessedWord(guessedWord);
        if (wordCheck) {
            score = score + 10;
        }
        return score;
    }

}
