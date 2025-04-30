package com.api.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.api.models.User;
import com.api.api.repository.UserRepository;

@Service
public class AdminsDashboardService {

    private final UserRepository userRepo;

    public AdminsDashboardService(UserRepository userRepo) 
    {
        this.userRepo = userRepo;
    }


    public Optional<List<User>> getAllUsers() 
    {
        return Optional.of(userRepo.findAll());
    }

}
