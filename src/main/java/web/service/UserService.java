package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    void addUser(User user);

    void removeUser(Long id);

    void editUser(User user);

    User getUser(Long id);
}
