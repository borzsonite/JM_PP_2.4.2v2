package edu.segeyrozhkov.crud.app.service;

import edu.segeyrozhkov.crud.app.model.User;

import java.util.List;

public interface UserService {

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);

    public List<User> userList();
}
