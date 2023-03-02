package net.springkata.springboot.dao;

import net.springkata.springboot.model.User;


import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUserById(int id);

    void addUser(User user);

    void removeUser(int id);

    void updateUser(int id , User user);

}