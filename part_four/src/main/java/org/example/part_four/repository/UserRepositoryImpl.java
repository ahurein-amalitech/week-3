package org.example.part_four.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.part_four.contract.UserRepository;
import org.example.part_four.dto.CreateUserDto;
import org.example.part_four.dto.UpdateUserDto;
import org.example.part_four.entity.User;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public User addUser(CreateUserDto createUserDto) {
        System.out.println(createUserDto.toString());
        var user = new User();
        user.setAge(createUserDto.age);
        user.setFirstName(createUserDto.firstName);
        user.setLastName(createUserDto.lastName);
        users.add(user);
        return user;
    }

    @Override
    public User getUser(int id) {
        isIndexValid(id);
        return users.get(id-1);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User updateUser(int id, UpdateUserDto updateUserDto) {
        var user = getUser(id);
        copyUserProperties(updateUserDto, user);
        users.set(id-1, user);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        isIndexValid(id);
        users.remove(id-1);
    }

    private void isIndexValid(int index){
        if(!(index <= users.size() && index > 0)){
            throw new NoSuchElementException("No user exist with the provided id");
        }
    }

    private void copyUserProperties(UpdateUserDto userDto, User user) {
        for (Field field : UpdateUserDto.class.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(userDto);
                if(value != null){
                    Field userField = User.class.getDeclaredField(field.getName());
                    userField.setAccessible(true);
                    userField.set(user, value);
                }
            } catch (Exception e) {
                throw new RuntimeException("Error updating user properties", e);
            }
        }
    }
}
