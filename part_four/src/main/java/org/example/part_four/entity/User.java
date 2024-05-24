package org.example.part_four.entity;

public class User {
    private String firstName;
    private String lastName;
    private Integer age;

    public User() {}

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return null;
    }

    @Override
    public String toString() {
        return STR."User{firstName='\{firstName}\{'\''}, lastName='\{lastName}\{'\''}, age=\{age}\{'}'}";
    }
}
