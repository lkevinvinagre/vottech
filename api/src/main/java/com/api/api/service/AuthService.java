package com.api.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.api.dto.SignInDto;
import com.api.api.dto.SignUpDto;
import com.api.api.models.User;
import com.api.api.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<String> signin(SignInDto signIn)
    {
        try
        {
            Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                signIn.getUserOrMail(), 
                signIn.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return Optional.of("Login realizado com sucesso");
        } finally
        {
            SecurityContextHolder.clearContext();
        }
    }

    public Optional<String> signUp(SignUpDto signUp)
    {
        try 
        {
            if(userRepo.existsByName(signUp.getName())) return Optional.of("Nome de usuario já Existente");
            if(userRepo.existsByEmail(signUp.getEmail())) return Optional.of("Email já Existente");

            User newUser = new User();
            newUser.setName(signUp.getName());
            newUser.setEmail(signUp.getEmail());
            newUser.setPassword(passwordEncoder.encode(signUp.getPassword()));

            userRepo.save(newUser);
            return Optional.of("Usuario cadastrado");
        }
        catch (Exception e)
        {
            throw new RuntimeException("Erro ao armazenar usuario", e);
        }
    }

}
