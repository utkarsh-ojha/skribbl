package com.scribbl.chatserver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "room_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomGenerator {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "roomId")
    private String roomId;

    @Column(name = "guessedWord")
    private String guessedWord;

}
