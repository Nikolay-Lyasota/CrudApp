package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }
}
