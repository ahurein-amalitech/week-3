package org.example.part_four.service;

import org.example.part_four.contract.UserRepository;
import org.example.part_four.dto.CreateUserDto;
import org.example.part_four.dto.UpdateUserDto;
import org.example.part_four.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_add_user_and_return_added_user() {
        var createUserDto = new CreateUserDto("ebenezer", "ahurein", 5);
        var user = new User("ebenezer", "ahurein", 5);
        Mockito.when(userRepository.addUser(createUserDto)).thenReturn(user);

        var addedUser = userRepository.addUser(createUserDto);

        assertEquals(user.getAge(), addedUser.getAge());
        assertEquals(user.getFirstName(), addedUser.getFirstName());
        assertEquals(user.getLastName(), addedUser.getLastName());
    }

    @Test
    void should_get_user_by_id(){
        var userId =  1;
        var user = new User("ebenezer", "ahurein", 5);

        Mockito.when(userRepository.getUser(userId)).thenReturn(user);

        var userFound = userRepository.getUser(userId);

        assertEquals(user.getAge(), userFound.getAge());
        assertEquals(user.getFirstName(), userFound.getFirstName());
        assertEquals(user.getLastName(), userFound.getLastName());
    }

    @Test
    void should_get_all_users(){
        var userOne = new User("ebenezer", "ahurein", 5);
        var userTwo = new User("ebenezer1", "ahurein1", 9);
        List<User> users = new ArrayList<>();
        users.add(userOne);
        users.add(userTwo);

        Mockito.when(userRepository.getAllUsers()).thenReturn(users);
        var usersFound = userRepository.getAllUsers();

        assertEquals(usersFound.stream().count(), users.size());
        assertNotNull(users);
    }

    @Test
    void should_update_user_by_id(){
        var userId =  1;
        var user = new User("ebenezer", "ahurein", 5);
        var updateUserDto = new UpdateUserDto();
        updateUserDto.firstName = "New name";

        Mockito.when(userRepository.getUser(userId)).thenReturn(user);
        Mockito.when(userRepository.updateUser(userId, updateUserDto)).thenAnswer(invocationOnMock -> {
            user.setFirstName(updateUserDto.firstName);
            return user;
        });
        var updatedUser = userRepository.updateUser(userId, updateUserDto);

        assertEquals(updatedUser.getFirstName(), "New name");
        assertEquals(updatedUser.getAge(), user.getAge());
    }

    @Test
    void should_delete_user_by_id(){
        int userId = 1;
        userRepository.deleteUser(userId);
        verify(userRepository, times(1)).deleteUser(userId);
    }
}