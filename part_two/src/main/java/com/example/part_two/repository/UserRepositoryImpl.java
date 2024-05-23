package com.example.part_two.repository;

import com.example.part_two.contract.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    public String getUser(){
        return "Ahurein";
    }
}
