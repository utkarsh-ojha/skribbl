package com.scribbl.chatserver.controller;

import com.scribbl.chatserver.payload.RoomGeneratorDto;
import com.scribbl.chatserver.repository.RoomGeneratorRepo;
import com.scribbl.chatserver.services.RoomGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chatApi")
public class RoomGeneratorController {

    @Autowired
    private RoomGeneratorService roomGeneratorService;

    @Autowired
    private RoomGeneratorRepo roomGeneratorRepo;

    //Create Room
    @PostMapping("user/createroom")
    public ResponseEntity<RoomGeneratorDto> createRoom(@RequestBody String userName) {
        RoomGeneratorDto roomGeneratorDto = this.roomGeneratorService.createRoom(userName);
        return new ResponseEntity<>(roomGeneratorDto, HttpStatus.CREATED);
    }

    @PostMapping("user/joinroom")
    public ResponseEntity<RoomGeneratorDto> joinRoom(@RequestBody RoomGeneratorDto roomGeneratorDto) {
        this.roomGeneratorService.joinRoom(roomGeneratorDto);
        return new ResponseEntity<>(roomGeneratorDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("user/getAllUsersByRoomId")
    public List<String> getUsersByRoomId(@RequestBody String roomId) {
        return roomGeneratorService.getUsersByRoomId(roomId);
    }

}
