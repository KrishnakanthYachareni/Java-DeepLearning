package ua.epam.spring.hometask.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.dao.UserDao;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.UserService;

/**
 * @author Krishnakanth_Yachare
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDAO;

    public UserServiceImpl(UserDao dao) {
        this.userDAO = dao;
    }

    @Override
    public User save(User u) {
        return userDAO.save(u);
    }

    @Override
    public void remove(User u) {
        userDAO.remove(u);
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    public Collection<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

}
