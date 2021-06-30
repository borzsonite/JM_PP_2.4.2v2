package edu.segeyrozhkov.crud.app.dao;

import edu.segeyrozhkov.crud.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserDao extends JpaRepository<User, Integer> {
//
//    public void addUser(User user);
//
//    public void updateUser(User user);
//
//    public void removeUser(int id);
//
//    public User getUserById(int id);
//
//    public List<User> userList();


}
