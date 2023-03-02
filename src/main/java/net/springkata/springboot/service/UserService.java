package net.springkata.springboot.service;

import net.springkata.springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    Object getUserById(int id);

    void addUser(User user);

    void removeUser(int id);

    void updateUser(int id , User user);

}