package model.dao.impl;

import model.dao.DeliveryTypeDao;
import model.dao.mapper.impl.DeliveryTypeMapper;
import model.entity.DeliveryType;
import model.service.PropertyHolder;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeliveryTypeDaoImpl extends GenericDaoImpl<DeliveryType> implements DeliveryTypeDao {
    private static Logger logger = Logger.getLogger(GenericDaoImpl.class);
    private PropertyHolder propertyHolder = new PropertyHolder();

    DeliveryTypeDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(DeliveryType entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("insert.into.delivery-type"));
        } catch (SQLException e) {
            logger.error("Cant insert into deliveryType: " + e);
        }
    }

    @Override
    public DeliveryType findById(int id) {
        return genericFindById(propertyHolder.getPropValues("select.delivery.type.by.id"),
                new DeliveryTypeMapper(), logger,id);
    }

    @Override
    public List<DeliveryType> findAll() {
        return genericFindMany(propertyHolder.getPropValues("select.all.delivery-type"),
                new DeliveryTypeMapper(), logger);
    }

    @Override
    public void update(DeliveryType entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("update.delivery-type"));
        } catch (SQLException e) {
            logger.error("Cant update deliveryType: " + e);
        }
    }

    void fillCreateStatement(DeliveryType entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getDescription());
    }

    @Override
    public void delete(int id) {
        try {
            genericDelete(id, propertyHolder.getPropValues("delete.from.delivery-type"));
        } catch (SQLException e) {
            logger.error("Cant delete from deliveryType: " + e);
        }
    }

    @Override
    public void close() {
    }

    @Override
    public DeliveryType findDeliveryTypeByName(String name) {
        return genericFindOne(
                propertyHolder.getPropValues("select.delivery.type.by.name"),
                new DeliveryTypeMapper(),logger, name);
    }

    @Override
    public boolean deliveryTypeIsCreated(DeliveryType deliveryType) {
        return findDeliveryTypeByName(deliveryType.getName()) != null;
    }
}
