package com.scribbl.chatserver.services.impl;

import com.scribbl.chatserver.entity.RoomGenerator;
import com.scribbl.chatserver.payload.RoomGeneratorDto;
import com.scribbl.chatserver.repository.RoomGeneratorRepo;
import com.scribbl.chatserver.services.RoomGeneratorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RoomGeneratorServiceImpl implements RoomGeneratorService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RoomGeneratorRepo roomGeneratorRepo;

    @Override
    public RoomGeneratorDto createRoom(String username) {
        String roomId = generateNewRoomId().trim();
        RoomGeneratorDto newRoom = new RoomGeneratorDto();
        newRoom.setRoomId(roomId);
        newRoom.setUsername(username.trim());
        RoomGenerator roomGenerator = this.modelMapper.map(newRoom, RoomGenerator.class);
        RoomGenerator savedRoom = this.roomGeneratorRepo.save(roomGenerator);
        return this.modelMapper.map(savedRoom, RoomGeneratorDto.class);
    }

    @Override
    public void joinRoom(RoomGeneratorDto roomGeneratorDto) {
        String roomId = roomGeneratorDto.getRoomId();
        RoomGenerator roomGenerator = this.modelMapper.map(roomGeneratorDto, RoomGenerator.class);
        RoomGenerator savedRoomGenerator = this.roomGeneratorRepo.save(roomGenerator);
    }

    @Override
    public List<String> getUsersByRoomId(String roomId) {
        List<String> userNames = new ArrayList<>();
        List<RoomGenerator> roomGeneratorsUsers = this.roomGeneratorRepo.findAllByRoomId(roomId);
        for (int i = 0; i < roomGeneratorsUsers.size(); i++) {
            userNames.add(roomGeneratorsUsers.get(i).getUserName());
        }
        return userNames;
    }

    private String generateNewRoomId() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 4;
        Random random = new Random();

        String generatedId = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedId;
    }
}
