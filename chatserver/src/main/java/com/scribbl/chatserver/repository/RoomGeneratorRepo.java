package com.scribbl.chatserver.repository;

import com.scribbl.chatserver.entity.RoomGenerator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomGeneratorRepo extends JpaRepository<RoomGenerator, String> {
    List<RoomGenerator> findAllByRoomId(String RoomId);
}
