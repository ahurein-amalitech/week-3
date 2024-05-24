package org.example.part_four.dto;

public class CreateUserDto {
    public String firstName;
    public String lastName;
    public Integer age;

    public CreateUserDto() {}

    public CreateUserDto(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return STR."CreateUserDto{firstName='\{firstName}\{'\''}, lastName='\{lastName}\{'\''}, age=\{age}\{'}'}";
    }
}
