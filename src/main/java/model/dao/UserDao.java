package model.dao;

import model.entity.User;

public interface UserDao extends GenericDao<User> {
    User findUserByEmailAndPassword(String email, String password);
    boolean userIsRegistered(User user);
}
