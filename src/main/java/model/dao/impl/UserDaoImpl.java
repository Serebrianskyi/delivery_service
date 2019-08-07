package model.dao.impl;

import model.dao.UserDao;
import model.dao.mapper.impl.UserMapper;
import model.entity.User;
import model.service.PropertyHolder;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    private static Logger logger = Logger.getLogger(UserDaoImpl.class);
    private PropertyHolder propertyHolder = new PropertyHolder();

    UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("insert.into.user"));
        } catch (SQLException e) {
            logger.error("Cant insert into user: " + e);
        }
    }

    @Override
    public User findById(int id) {
        return genericFindById(propertyHolder.getPropValues("select.user.by.id"),
                new UserMapper(), logger,id);
    }

    @Override
    public List<User> findAll() {
        return genericFindMany(propertyHolder.getPropValues("select.all.user"), new UserMapper(), logger);
    }

    @Override
    public void update(User entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("update.user"));
        } catch (SQLException e) {
            logger.error("Cant update user: " + e);
        }
    }

    void fillCreateStatement(User entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getSurName());
        preparedStatement.setString(3, entity.getLastName());
        preparedStatement.setString(4, entity.getEmail());
        preparedStatement.setString(5, entity.getPassword());
        preparedStatement.setInt(6, entity.getRoleId());
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return genericFindOne(propertyHolder.getPropValues("select.user.by.email.password"),
                new UserMapper(), logger, email,password);
    }

    @Override
    public boolean userIsRegistered(User user) {
        return findUserByEmailAndPassword(user.getEmail(),user.getPassword()) != null;
    }

    @Override
    public void delete(int id) {
        try {
            genericDelete(id, propertyHolder.getPropValues("delete.from.user"));
        } catch (SQLException e) {
            logger.error("Cant delete from user: " + e);
        }
    }

    @Override
    public void close() {
    }
}
