package org.example.part_three.service;

import org.example.part_three.contract.UserRepository;
import org.example.part_three.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepositoryImpl;

    @Autowired
    public UserServiceImpl(UserRepository userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }

    public String getUser(){ return userRepositoryImpl.getUser();}

    public int getAge() {return userRepositoryImpl.getAge();}
}
