package org.example.part_four.service;

import org.example.part_four.contract.UserRepository;
import org.example.part_four.contract.UserService;
import org.example.part_four.dto.CreateUserDto;
import org.example.part_four.dto.UpdateUserDto;
import org.example.part_four.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepositoryImpl;

    @Autowired
    public UserServiceImpl(UserRepository userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }


    @Override
    public User addUser(CreateUserDto createUserDto) {
        var user = userRepositoryImpl.addUser(createUserDto);
        return user;
    }

    @Override
    public User getUser(int id) {
        return userRepositoryImpl.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoryImpl.getAllUsers();
    }

    @Override
    public User updateUser(int id, UpdateUserDto updateUserDto) {
        return userRepositoryImpl.updateUser(id, updateUserDto);
    }

    @Override
    public void deleteUser(int id) {
        userRepositoryImpl.deleteUser(id);
    }
}
