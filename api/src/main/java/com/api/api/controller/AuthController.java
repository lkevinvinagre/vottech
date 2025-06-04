package com.api.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api.dto.ResponseModel;
import com.api.api.dto.SignInDto;
import com.api.api.dto.SignUpDto;
import com.api.api.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/auth")
public class AuthController 
{

    @Autowired
    private AuthService authService;

    @GetMapping("/test")
    public ResponseEntity<?> test() 
    {
        return ResponseEntity.status(200).body("Api esta funcional");
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseModel> signUpUser(@RequestBody SignUpDto signup) 
    {
        ResponseModel responseDto = authService.signUp(signup);
        return ResponseEntity.status(responseDto.getStatus()).body(responseDto);
    }

    @PostMapping("/signin")
    public ResponseEntity<ResponseModel> signInUser(@RequestBody SignInDto signin)
    {
        ResponseModel responseDto = authService.signIn(signin);
        return ResponseEntity.status(responseDto.getStatus()).body(responseDto);
    }
}
