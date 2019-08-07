package model.service.impl;

import model.dao.FactoryDao;
import model.dao.UserDao;
import model.entity.User;
import model.service.GenericService;
import org.apache.log4j.Logger;

import java.util.List;

public class UserService implements GenericService<User> {
    private Logger logger = Logger.getLogger(UserService.class);
    private FactoryDao factoryDao = FactoryDao.getInstance();
    private UserDao userDao = factoryDao.createUserDao();

    @Override
    public void create(User entity) {
        userDao.create(entity);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void update(User entity) {
        userDao.update(entity);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    public User findUserByEmailAndPassword(String email, String password){
        return userDao.findUserByEmailAndPassword(email,password);
    }

    public boolean userIsRegistered(User user) {
        return userDao.userIsRegistered(user);
    }
}
