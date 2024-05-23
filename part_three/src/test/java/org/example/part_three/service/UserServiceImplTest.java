package org.example.part_three.service;

import org.example.part_three.contract.UserRepository;
import org.example.part_three.contract.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @BeforeEach
    void setup(){
        Mockito.when(userRepository.getUser()).thenReturn("ahurein");
    }

    @Test
    void getNameShouldReturnUsername(){
        String user = userRepository.getUser();
        assertEquals("ahurein", user);
    }

}