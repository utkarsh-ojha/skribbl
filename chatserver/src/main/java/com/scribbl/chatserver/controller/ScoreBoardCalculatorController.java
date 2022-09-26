package com.scribbl.chatserver.controller;


import com.scribbl.chatserver.payload.RoomGeneratorDto;
import com.scribbl.chatserver.services.impl.ScoreBoardCalculatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreBoardCalculatorController {

    @Autowired
    private ScoreBoardCalculatorImpl scoreBoardCalculatorImpl;

    private int individualScore;


    @GetMapping("user/finalScore")
    public int  getUserScore(@RequestBody RoomGeneratorDto roomGeneratorDto) {
        return 0;
    }
}
