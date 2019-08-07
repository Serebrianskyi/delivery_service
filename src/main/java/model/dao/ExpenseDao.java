package model.dao;

import model.entity.Expense;

import java.util.List;

public interface ExpenseDao extends GenericDao<Expense> {
    List<Expense> findExpensesByUserId(int id);

    List<Expense> findExpensesByTariffId(int id);

    List<Expense> findExpensesByWeightId(int id);
}
