package com.api.api.dto;

import lombok.Data;

@Data
public class ResponseModel {

    private int status;

    private String message;

    public ResponseModel() {
    }
    
}
