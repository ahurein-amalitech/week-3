package org.example.part_four.controller;

import org.example.part_four.contract.UserRepository;
import org.example.part_four.dto.CreateUserDto;
import org.example.part_four.dto.UpdateUserDto;
import org.example.part_four.entity.User;
import org.example.part_four.repository.UserRepositoryImpl;
import org.example.part_four.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        return ResponseEntity.ok(this.userService.getUser(id));
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto){
        var user = userService.addUser(createUserDto);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody UpdateUserDto updateUserDto){
        var user = userService.updateUser(id, updateUserDto);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return  new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }

}
