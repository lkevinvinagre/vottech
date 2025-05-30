package com.api.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.status(202).body("Api esta funcional");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody SignUpDto signup) 
    {
        Optional<String> response = authService.signUp(signup);
        if(response.isPresent()){
            return (response.get().equals("Usuario cadastrado")) 
                ? ResponseEntity.status(201).body(response.get())
                : ResponseEntity.status(409).body(response.get());
        }else
        {
            return ResponseEntity.status(500).body("Erro ao cadastrar usuario");
        }
    }

    @PostMapping("/signin")
    public String signInUser(@RequestBody SignInDto signin)
    {
        Optional<String> response = authService.signin(signin);

        return response.get();
    }

}
