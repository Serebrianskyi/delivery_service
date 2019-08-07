package model.dao.impl;

import model.dao.RoleDao;
import model.dao.mapper.impl.RoleMapper;
import model.entity.Role;
import model.service.PropertyHolder;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RoleDaoImpl  extends GenericDaoImpl<Role> implements RoleDao {
    private static Logger logger = Logger.getLogger(RoleDaoImpl.class);
    private PropertyHolder propertyHolder = new PropertyHolder();

    RoleDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Role entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("insert.into.role"));
        } catch (SQLException e) {
            logger.error("Cant insert into role: " + e);
        }
    }

    @Override
    public Role findById(int id) {
        return genericFindById(propertyHolder.getPropValues("select.role.by.id"),
                new RoleMapper(), logger,id);
    }

    @Override
    public List<Role> findAll() {
        return genericFindMany(propertyHolder.getPropValues("select.all.role"), new RoleMapper(), logger);
    }

    @Override
    public void update(Role entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("update.role"));
        } catch (SQLException e) {
            logger.error("Cant update role: " + e);
        }
    }

    void fillCreateStatement(Role entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getDescription());
    }

    @Override
    public void delete(int id) {
        try {
            genericDelete(id, propertyHolder.getPropValues("delete.from.role"));
        } catch (SQLException e) {
            logger.error("Cant delete from role: " + e);
        }
    }

    @Override
    public void close() {
    }
}
