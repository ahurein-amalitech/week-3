package org.example.part_three.repository;

import org.example.part_three.contract.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public String getUser(){
        return "Ahurein";
    }

    @Override
    public int getAge() {
        return 6;
    }
}
