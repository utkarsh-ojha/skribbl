package com.scribbl.chatserver.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RoomGeneratorDto {

    private String roomId;

    private String username;
}
