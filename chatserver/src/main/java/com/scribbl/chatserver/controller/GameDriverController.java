package com.scribbl.chatserver.controller;

import com.scribbl.chatserver.services.impl.GameDriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameDriverController {

    @Autowired
    private GameDriverServiceImpl gameDriverService;


    @GetMapping("/scribbl")
    public ResponseEntity <?> scribbl(@RequestBody String option) //create or join
    {
        if (option.equals("create")){
            //create room api
            //startGame dunction call

        }
        else {
            //join room api
            //startGame dunction call
        }

        return null;
    }

}
