package org.example.part_four.dto;

public class UpdateUserDto {
    public String firstName;
    public String lastName;
    public Integer age;

    public UpdateUserDto() {}

    public UpdateUserDto(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
