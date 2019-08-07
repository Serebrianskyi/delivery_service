package model.service.impl;

import model.dao.ExpenseDao;
import model.dao.FactoryDao;
import model.entity.Expense;
import model.service.GenericService;
import org.apache.log4j.Logger;

import java.util.List;

public class ExpenseService implements GenericService<Expense> {
    private Logger logger = Logger.getLogger(ExpenseService.class);
    private FactoryDao factoryDao = FactoryDao.getInstance();
    private ExpenseDao expenseDao = factoryDao.createExpenseDao();

    @Override
    public void create(Expense entity) {
        expenseDao.create(entity);
    }

    @Override
    public Expense findById(int id) {
        return expenseDao.findById(id);
    }

    @Override
    public List<Expense> findAll() {
        return expenseDao.findAll();
    }

    public List<Expense> findExpensesByUserId(int id) {
        return expenseDao.findExpensesByUserId(id);
    }

    public List<Expense> findExpensesByTariffId(int id) {
        return expenseDao.findExpensesByTariffId(id);
    }

    public List<Expense> findExpensesByWeightId(int id) {
        return expenseDao.findExpensesByWeightId(id);
    }

    @Override
    public void update(Expense entity) {
        expenseDao.update(entity);
    }

    @Override
    public void delete(int id) {
        expenseDao.delete(id);
    }
}
