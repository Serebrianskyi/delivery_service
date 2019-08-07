package model.dao.impl;

import model.dao.RequestDao;
import model.dao.mapper.impl.RequestMapper;
import model.entity.Request;
import model.service.PropertyHolder;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RequestDaoImpl extends GenericDaoImpl<Request> implements RequestDao {
    private static Logger logger = Logger.getLogger(RequestDaoImpl.class);
    private PropertyHolder propertyHolder = new PropertyHolder();

    RequestDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Request entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("insert.into.request"));
        } catch (SQLException e) {
            logger.error("Cant insert into request: " + e);
        }
    }

    @Override
    public Request findById(int id) {
        return genericFindById(propertyHolder.getPropValues("select.request.by.id"),
                new RequestMapper(), logger,id);
    }

    @Override
    public List<Request> findAll() {
        return genericFindMany(propertyHolder.getPropValues("select.all.request"), new RequestMapper(), logger);
    }

    @Override
    public List<Request> findRequestsByUserId(int id) {
        return genericFindMany(propertyHolder.getPropValues("select.request.by.user.id"),
                new RequestMapper(), logger,String.valueOf(id));
    }

    @Override
    public List<Request> findRequestsByTariffId(int id) {
        return genericFindMany(propertyHolder.getPropValues("select.request.by.tariff-id"),
                new RequestMapper(), logger);
    }

    @Override
    public List<Request> findRequestsByWeightId(int id) {
        return genericFindMany(propertyHolder.getPropValues("select.request.by.weight-id"),
                new RequestMapper(), logger);
    }

    @Override
    public void update(Request entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("update.request"));
        } catch (SQLException e) {
            logger.error("Cant update request: " + e);
        }
    }

    void fillCreateStatement(Request entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setDate(1, Date.valueOf(entity.getDate()));
        preparedStatement.setInt(2, entity.getUserId());
        preparedStatement.setInt(3, entity.getTariffId());
        preparedStatement.setInt(4, entity.getWeightId());
    }

    @Override
    public void delete(int id) {
        try {
            genericDelete(id, propertyHolder.getPropValues("delete.from.request"));
        } catch (SQLException e) {
            logger.error("Cant delete from request: " + e);
        }
    }

    @Override
    public void close() {
    }
}