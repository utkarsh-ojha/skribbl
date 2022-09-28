package com.scribbl.chatserver.services.impl;

import com.scribbl.chatserver.services.GameDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class GameDriverServiceImpl implements GameDriverService {

    private final String URL_GET_ALL_USER = "/chatApi/user/getAllUsersByRoomId";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object startGame(String roomId) {

        //calling getUsersByRoomId()or api to fetch user details.
        List<String> userList = restTemplate.getForObject(URL_GET_ALL_USER, ArrayList.class);
        SortedMap<String, Integer> scoreMap = new TreeMap<>();
        for (String user : userList) {
            scoreMap.put(user, 0);
        }
        //looping user for each iteration.

        // one user choose a word and others starts guessing
        for(String user1:userList){
            // each user gets a chance to choose a particular word
            for(String user2:userList) {
                // other user's will try to guess that word
                if (user1.equals(user2)) {
                    continue;
                }
                // calculate the score according to successful match of guessed word
                scoreMap.put(user2,scoreMap.get(user2)+100);
                // every user will get the score updated like this
            }
        }

        return null;
    }
}
