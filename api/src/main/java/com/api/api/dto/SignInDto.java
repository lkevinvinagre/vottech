package com.api.api.dto;

import lombok.Data;

@Data
public class SignInDto 
{
    private String userOrMail;
    private String password;
}
