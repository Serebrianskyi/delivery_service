package model.dao.impl;

import model.dao.*;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class FactoryDaoImpl extends FactoryDao {
    private static Logger logger = Logger.getLogger(FactoryDaoImpl.class);
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("Cant get connection: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public DeliveryTypeDao createDeliveryTypeDao() {
        return new DeliveryTypeDaoImpl(getConnection());
    }

    @Override
    public DepartmentDao createDepartmentDao() {
        return new DepartmentDaoImpl(getConnection());
    }

    @Override
    public ExpenseDao createExpenseDao() {
        return new ExpenseDaoImpl(getConnection());
    }

    @Override
    public RequestDao createRequestDao() {
        return new RequestDaoImpl(getConnection());
    }

    @Override
    public RoleDao createRoleDao() {
        return new RoleDaoImpl(getConnection());
    }

    @Override
    public ScheduleDao createScheduleDao() {
        return new ScheduleDaoImpl(getConnection());
    }

    @Override
    public TariffDao createTariffDao() {
        return new TariffDaoImpl(getConnection());
    }

    @Override
    public UserDao createUserDao() {
        return new UserDaoImpl(getConnection());
    }

    @Override
    public WeightDao createWeightDao() {
        return new WeightDaoImpl(getConnection());
    }
}
