package com.scribbl.chatserver.services.impl;

import com.scribbl.chatserver.services.GameDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameDriverServiceImpl implements GameDriverService {

    private final String URL_GET_ALL_USER = "/chatApi/user/getAllUsersByRoomId";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object startGame(String roomId) {

        //calling getUsersByRoomId()or api to fetch user details.
        List<String> userList = restTemplate.getForObject(URL_GET_ALL_USER, ArrayList.class);
        Map<String, Integer> scoreMap = new HashMap<>();
        for (String user : userList) {
            scoreMap.put(user, 0);
        }
        //looping user for each iteration.
        return null;
    }
}
