package com.scribbl.chatserver.repository;

import com.scribbl.chatserver.entity.RoomGenerator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomGeneratorRepo extends JpaRepository<RoomGenerator, String> {

}
