package model.dao.impl;

import model.dao.ExpenseDao;
import model.dao.mapper.impl.ExpenseMapper;
import model.entity.Expense;
import model.service.PropertyHolder;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ExpenseDaoImpl extends GenericDaoImpl<Expense> implements ExpenseDao {
    private static Logger logger = Logger.getLogger(ExpenseDaoImpl.class);
    private PropertyHolder propertyHolder = new PropertyHolder();

    ExpenseDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Expense entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("insert.into.expense"));
        } catch (SQLException e) {
            logger.error("Cant insert into expense: " + e);
        }
    }

    @Override
    public Expense findById(int id) {
        return genericFindById(propertyHolder.getPropValues("select.expense.by.id"),
                new ExpenseMapper(), logger, id);
    }

    @Override
    public List<Expense> findAll() {
        return genericFindMany(propertyHolder.getPropValues("select.all.expense"),
                new ExpenseMapper(), logger);
    }

    @Override
    public List<Expense> findExpensesByUserId(int id) {
        return genericFindMany(propertyHolder.getPropValues("select.expense.by.user-id"),
                new ExpenseMapper(), logger);
    }

    @Override
    public List<Expense> findExpensesByTariffId(int id) {
        return genericFindMany(propertyHolder.getPropValues("select.expense.by.tariff-id"),
                new ExpenseMapper(), logger);
    }

    @Override
    public List<Expense> findExpensesByWeightId(int id) {
        return genericFindMany(propertyHolder.getPropValues("select.expense.by.weight-id"),
                new ExpenseMapper(), logger);
    }

    @Override
    public void update(Expense entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("update.expense"));
        } catch (SQLException e) {
            logger.error("Cant update expense: " + e);
        }
    }

    void fillCreateStatement(Expense entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, entity.getPrice());
        preparedStatement.setInt(2, entity.getRequestId());
    }

    @Override
    public void delete(int id) {
        try {
            genericDelete(id, propertyHolder.getPropValues("delete.from.expense"));
        } catch (SQLException e) {
            logger.error("Cant delete from expense: " + e);
        }
    }

    @Override
    public void close() {
    }
}
