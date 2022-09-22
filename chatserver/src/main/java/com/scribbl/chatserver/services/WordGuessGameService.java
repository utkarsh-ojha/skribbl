package com.scribbl.chatserver.services;

public interface WordGuessGameService {

    //Random word selector
    public String pickRandomWord();

    public boolean checkTheGuessedWord(String gussedWord);
}
