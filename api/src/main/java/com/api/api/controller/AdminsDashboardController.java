package com.api.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api.service.AdminsDashboardService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminsDashboardController 
{
    @Autowired
    AdminsDashboardService adminsDashService;

    @GetMapping("/listusers")
    public ResponseEntity<?> listUsers() {
        Optional<?> response = adminsDashService.getAllUsers();
        return (response.isPresent())
            ?ResponseEntity.status(200).body(response.get())
            :ResponseEntity.status(404).body("Não a usuarios cadastrados");
    }
    
}
