package org.example.part_four.service;

import org.example.part_four.contract.UserRepository;
import org.example.part_four.contract.UserService;
import org.example.part_four.dto.CreateUserDto;
import org.example.part_four.dto.UpdateUserDto;
import org.example.part_four.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        var createUserDto = new CreateUserDto("ebenezer", "ahurein", 5);
        var user = new User("ebenezer", "ahurein", 5);
        var updateUserDto = new UpdateUserDto();
        updateUserDto.age = 50;

        Mockito.when(userService.addUser(createUserDto)).thenReturn(new User("ebenezer", "ahurein", 5));
        Mockito.when(userService.getUser(1)).thenReturn(user);
        Mockito.when(userService.getAllUsers()).thenReturn(List.of(new User[]{user}));
        Mockito.when(userService.updateUser(1, updateUserDto)).thenReturn(user.setAge(50));
    }

    @Test
    void getUserShouldReturnTheUser() {
        var user = userService.getUser(1);
        assertEquals(user.getAge(), 50);
    }

    @Test
    void getAllUsersShouldReturnAllUsers() {
        var users = userService.getAllUsers();
        assertEquals(users.size(), 1);
    }

}