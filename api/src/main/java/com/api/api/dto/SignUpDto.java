package com.api.api.dto;

import lombok.Data;

@Data
public class SignUpDto 
{
    private String name;
    private String email;
    private String password;
    private String faceData;
    private String imagePath;
    private String faceId;
}
