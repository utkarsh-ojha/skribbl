package com.scribbl.chatserver.services.impl;

import com.scribbl.chatserver.services.GameDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GameDriverServiceImpl implements GameDriverService {


    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Object startGame() {

        //calling getUsersByRoomId()or api to fetch user details.

        //looping user for each iteration.
        return null;
    }
}
