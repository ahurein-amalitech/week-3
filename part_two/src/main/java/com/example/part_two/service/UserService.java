package com.example.part_two.service;

import com.example.part_two.contract.UserRepository;
import com.example.part_two.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepositoryImpl;

    @Autowired
    public UserService(UserRepository userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }

    public String getUser(){
        return userRepositoryImpl.getUser();
    }
}
