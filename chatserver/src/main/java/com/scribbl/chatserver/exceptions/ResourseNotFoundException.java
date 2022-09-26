package com.scribbl.chatserver.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourseNotFoundException extends RuntimeException {

    String resourseName;
    String fieldName;
    String fieldValue;

    public ResourseNotFoundException(String resourseName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : %s", resourseName, fieldName, fieldValue));
        this.resourseName = resourseName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
