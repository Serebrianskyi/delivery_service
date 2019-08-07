package model.dao.impl;

import model.dao.WeightDao;
import model.dao.mapper.impl.WeightMapper;
import model.entity.Weight;
import model.service.PropertyHolder;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WeightDaoImpl extends GenericDaoImpl<Weight> implements WeightDao {
    private static Logger logger = Logger.getLogger(WeightDaoImpl.class);
    private PropertyHolder propertyHolder = new PropertyHolder();

    WeightDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Weight entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("insert.into.weight"));
        } catch (SQLException e) {
            logger.error("Cant insert into weight: " + e);
        }
    }

    @Override
    public Weight findById(int id) {
        return genericFindById(propertyHolder.getPropValues("select.weight.by.id"),
                new WeightMapper(), logger,id);
    }

    @Override
    public List<Weight> findAll() {
        return genericFindMany(propertyHolder.getPropValues("select.all.weight"), new WeightMapper(), logger);
    }

    @Override
    public void update(Weight entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("update.weight"));
        } catch (SQLException e) {
            logger.error("Cant update weight: " + e);
        }
    }

    void fillCreateStatement(Weight entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setDouble(1, entity.getValue());
        preparedStatement.setDouble(2, entity.getCoefficient());
    }

    @Override
    public void delete(int id) {
        try {
            genericDelete(id, propertyHolder.getPropValues("delete.from.weight"));
        } catch (SQLException e) {
            logger.error("Cant delete from weight: " + e);
        }

    }

    @Override
    public void close() {
    }

    @Override
    public Weight findWeightByValueAndCoefficient(double value, double coefficient) {
        return genericFindOne(propertyHolder.getPropValues("select.weight.by.value.and.coefficient"),
                new WeightMapper(), logger, String.valueOf(value) ,String.valueOf(coefficient));
    }

    @Override
    public Weight findWeightByValue(double value) {
        return genericFindOne(propertyHolder.getPropValues("select.weight.by.value"),
                new WeightMapper(), logger, String.valueOf(value));
    }

    @Override
    public boolean weightIsCreated(Weight weight) {
        return findWeightByValueAndCoefficient(weight.getValue(),weight.getCoefficient()) != null;
    }
}
