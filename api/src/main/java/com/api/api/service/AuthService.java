package com.api.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.api.dto.ResponseModel;
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


    public ResponseModel signin(SignInDto signIn)
    {
        ResponseModel response = new ResponseModel();
        try
        {
            if(!userRepo.existsByName(signIn.getUserOrMail()) && !userRepo.existsByEmail(signIn.getUserOrMail())) {
                response.setMessage("Usuario ou Email não encontrado");
                response.setStatus(404);
                return response;
            }
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                      signIn.getUserOrMail(), 
                      signIn.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            response.setMessage("Login realizado com sucesso");
            response.setStatus(200);
            return response;

        }
        catch (Exception e)
        {
            response.setMessage("Erro ao logar usuario: " + e.getMessage());
            response.setStatus(500);
            return response;
        } 
    }

    public ResponseModel signUp(SignUpDto signUp)
    {
        ResponseModel response = new ResponseModel();
        try 
        {
            if(userRepo.existsByName(signUp.getName()) || 
            userRepo.existsByEmail(signUp.getEmail()))
            {
                response.setMessage("Usuario ou Email já cadastrado");
                response.setStatus(400);
                return response;
            }

            User newUser = new User();
            newUser.setName(signUp.getName());
            newUser.setEmail(signUp.getEmail());
            newUser.setPassword(passwordEncoder.encode(signUp.getPassword()));
            userRepo.save(newUser);
            response.setMessage("Usuario cadastrado");
            response.setStatus(200);
            return response;
        }
        catch (Exception e)
        {
            response.setStatus(500);
            response.setMessage("Erro ao cadastrar usuario: " + e.getMessage());
            return response;
        }
    }

}
