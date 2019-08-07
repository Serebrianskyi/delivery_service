package model.dao.impl;

import model.dao.DepartmentDao;
import model.dao.mapper.impl.DepartmentMapper;
import model.entity.Department;
import model.service.PropertyHolder;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoImpl extends GenericDaoImpl<Department> implements DepartmentDao {
    private static Logger logger = Logger.getLogger(DepartmentDaoImpl.class);
    private PropertyHolder propertyHolder = new PropertyHolder();

    DepartmentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Department entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("insert.into.departments"));
        } catch (SQLException e) {
            logger.error("Cant insert into department: " + e);
        }
    }

    @Override
    public Department findById(int id) {
        return genericFindById(propertyHolder.getPropValues("select.department.by.id"),
                new DepartmentMapper(), logger,id);
    }

    @Override
    public List<Department> findAll() {
        return genericFindMany(propertyHolder.getPropValues("select.all.department"),
                new DepartmentMapper(), logger);
    }

    @Override
    public void update(Department entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("update.department"));
        } catch (SQLException e) {
            logger.error("Cant update department: " + e);
        }
    }

    void fillCreateStatement(Department entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getTown());
        preparedStatement.setString(2, entity.getStreet());
        preparedStatement.setString(3, entity.getBuildingNumber());
        preparedStatement.setInt(4, entity.getSheduleId());
    }

    @Override
    public void delete(int id) {
        try {
            genericDelete(id, propertyHolder.getPropValues("delete.from.department"));
        } catch (SQLException e) {
            logger.error("Cant delete from department: " + e);
        }
    }

    @Override
    public void close() {
    }

    @Override
    public Department findDepartmentByTown(String town) {
        return genericFindOne(
                propertyHolder.getPropValues("select.department.by.town"),
                new DepartmentMapper(),logger, town);
    }

    @Override
    public Department findDepartmentByTownAndStreet(String town, String street) {
        return genericFindOne(
                propertyHolder.getPropValues("select.department.by.town.and.street"),
                new DepartmentMapper(),logger, town, street);
    }

    @Override
    public boolean departmentIsCreated(Department department) {
        return findDepartmentByTownAndStreet(department.getTown(),
                department.getStreet()) != null;
    }
}