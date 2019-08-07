package model.dao.mapper.impl;

import model.dao.mapper.ObjectMapper;
import model.entity.Expense;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseMapper implements ObjectMapper<Expense> {
    @Override
    public Expense mapResultSetToEntity(ResultSet rs) throws SQLException {
        Expense expense = new Expense();
        expense.setId(rs.getInt("id"));
        expense.setPrice(rs.getLong("price"));
        expense.setRequestId(rs.getInt("requestId"));
        return expense;
    }
}
