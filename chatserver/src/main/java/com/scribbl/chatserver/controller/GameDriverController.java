package com.scribbl.chatserver.controller;

import com.scribbl.chatserver.payload.RoomGeneratorDto;
import com.scribbl.chatserver.services.impl.GameDriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GameDriverController {

    private final String URL_CREATE_ROOM = "/chatApi/user/createroom";
    private final String URL_Join_ROOM = "/chatApi/user/joinroom";

    @Autowired
    private GameDriverServiceImpl gameDriverService;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/scribbl")
    public ResponseEntity<?> scribbl(@RequestParam(name = "username", required = false) String userName, @RequestParam(name = "roomGeneratorDto", required = false) RoomGeneratorDto roomGeneratorDto) //create or join
    {
        if (!userName.equals("") && roomGeneratorDto == null) {
            //create room api
            ResponseEntity<RoomGeneratorDto> responseEntity = restTemplate.getForEntity(URL_CREATE_ROOM, RoomGeneratorDto.class, userName);

            //startGame dunction call

        } else if (userName.equals("") && roomGeneratorDto != null) {
            //join room api
            ResponseEntity<RoomGeneratorDto> responseEntity = restTemplate.getForEntity(URL_CREATE_ROOM, RoomGeneratorDto.class, roomGeneratorDto);
            //startGame dunction call
        }

        return null;
    }

}
