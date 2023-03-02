package net.springkata.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import net.springkata.springboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {


    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u" , User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class , id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(int id) {
        entityManager.remove(getUserById(id));
    }


    @Override
    public void updateUser(int id , User user) {
        User searchUser = entityManager.find(User.class , id);
        searchUser.setAge(user.getAge());
        searchUser.setEmail(user.getEmail());
        searchUser.setLastName(user.getLastName());
        searchUser.setName(user.getName());
        searchUser.setPassword(user.getPassword());
        searchUser.setRoles(user.getRoles());
    }

}
