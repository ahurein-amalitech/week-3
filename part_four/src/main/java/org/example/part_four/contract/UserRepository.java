package org.example.part_four.contract;

import org.example.part_four.dto.CreateUserDto;
import org.example.part_four.dto.UpdateUserDto;
import org.example.part_four.entity.User;

import java.util.List;

public interface UserRepository {
    User addUser(CreateUserDto createUserDto);
    User getUser(int id);
    List<User> getAllUsers();
    User updateUser(int id, UpdateUserDto updateUserDto);
    void deleteUser(int id);
}