package com.api.api.service;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.api.models.User;
import com.api.api.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService
{

    private final UserRepository userRepo;

    public CustomUserDetailsService(UserRepository userRepo)
    {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String nameOrMail) throws UsernameNotFoundException
    {
        User user = userRepo.findByNameOrEmail(nameOrMail, nameOrMail).orElseThrow(
            () -> new UsernameNotFoundException("Usuario: " + nameOrMail+" não encontrado"));
        Set<GrantedAuthority> authorities = Set.of(new SimpleGrantedAuthority("ROLE_"+user.getRole().toString()));

        return new org.springframework.security.core.userdetails.User(
            user.getEmail(), 
            user.getPassword(), 
            authorities);
    }
}
