package model.dao.impl;

import model.dao.GenericDao;
import model.dao.mapper.ObjectMapper;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
    Connection connection;

    public void genericCreate(T entity, String query) throws SQLException {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            fillCreateStatement(entity, preparedStatement);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException(e);
        }
    }

    T genericFindById(String query, ObjectMapper<T> objectMapper, Logger logger, Integer id) {
        ResultSet resultSet;
        T entity = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareCall(query);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entity = objectMapper.mapResultSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Cant execute query: " + e);
        }
        return entity;
    }

    List<T> genericFindMany(String query, ObjectMapper<T> objectMapper, Logger logger, String...parameters) {
        ResultSet resultSet;
        List<T> objectsList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    connection.prepareCall(query);
            for (int i = 1; i <= parameters.length; i++) {
                preparedStatement.setString(i,parameters[i-1]);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objectsList.add(objectMapper.mapResultSetToEntity(resultSet));
            }
        } catch (SQLException e) {
            logger.error("Cant execute query: " + e);
        }
        return objectsList;
    }

    T genericFindOne(String query, ObjectMapper<T> objectMapper, Logger logger,String...parameters) {
        ResultSet resultSet;
        T object = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareCall(query);
            for (int i = 1; i <= parameters.length; i++) {
                preparedStatement.setString(i,parameters[i-1]);
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                object = objectMapper.mapResultSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Cant execute query: " + e);
        }
        return object;
    }

    void genericDelete(int objectId, String query) throws SQLException {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);
            preparedStatement.setInt(1, objectId);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException(e);
        }
    }

    abstract void fillCreateStatement(T entity, PreparedStatement preparedStatement) throws SQLException;
}
