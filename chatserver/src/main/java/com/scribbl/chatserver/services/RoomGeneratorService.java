package com.scribbl.chatserver.services;

import com.scribbl.chatserver.payload.RoomGeneratorDto;
import org.springframework.stereotype.Service;

public interface RoomGeneratorService {

    //Create room
    RoomGeneratorDto createRoom(String username);

    //Join room
    void joinRoom(RoomGeneratorDto roomGeneratorDto);

}
