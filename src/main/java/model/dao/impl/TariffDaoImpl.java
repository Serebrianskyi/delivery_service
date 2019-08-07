package model.dao.impl;

import model.dao.TariffDao;
import model.dao.mapper.impl.TariffMapper;
import model.entity.Tariff;
import model.service.PropertyHolder;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TariffDaoImpl extends GenericDaoImpl<Tariff> implements TariffDao {
    private static Logger logger = Logger.getLogger(TariffDaoImpl.class);
    private PropertyHolder propertyHolder = new PropertyHolder();

    TariffDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Tariff entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("insert.into.tariff"));
        } catch (SQLException e) {
            logger.error("Cant insert into tariff: " + e);
        }
    }

    @Override
    public Tariff findById(int id) {
        return genericFindById(propertyHolder.getPropValues("select.tariff.by.id"),
                new TariffMapper(), logger,id);
    }

    @Override
    public List<Tariff> findAll() {
        return genericFindMany(propertyHolder.getPropValues("select.all.tariff"), new TariffMapper(), logger);
    }

    @Override
    public void update(Tariff entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("update.tariff"));
        } catch (SQLException e) {
            logger.error("Cant update tariff: " + e);
        }
    }

    void fillCreateStatement(Tariff entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, entity.getValue());
        preparedStatement.setLong(2, entity.getPrice());
        preparedStatement.setInt(3, entity.getDepartmentFromId());
        preparedStatement.setInt(4, entity.getDepartmentToId());
        preparedStatement.setInt(5, entity.getDeliveryTypeId());
    }

    @Override
    public void delete(int id) {
        try {
            genericDelete(id, propertyHolder.getPropValues("delete.from.tariff"));
        } catch (SQLException e) {
            logger.error("Cant delete from tariff: " + e);
        }
    }

    @Override
    public void close() {
    }

    @Override
    public Tariff findTariffByDepartmentFromAndDepartmentToAndDeliveryType(Integer from, Integer to,Integer deliveryType) {
        return genericFindOne(
                propertyHolder.
                        getPropValues("select.tariff.by.department.from.and.department.to.and.delivery.type"),
                new TariffMapper(), logger, String.valueOf(from), String.valueOf(to),String.valueOf(deliveryType));
    }

    @Override
    public boolean tariffIsCreated(Tariff tariff) {
        return findTariffByDepartmentFromAndDepartmentToAndDeliveryType(tariff.getDepartmentFromId(),
                tariff.getDepartmentToId(),tariff.getDeliveryTypeId()) != null;
    }
}
