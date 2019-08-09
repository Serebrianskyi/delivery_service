package model.service.impl;

import model.dao.ExpenseDao;
import model.entity.Expense;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseServiceTest {
    Expense expense;
    List<Expense> expenseList;

    @Before
    public void setUp() {
        expenseList = new ArrayList<>();
        expense = new Expense(1, 1,true, 1);
        expenseList.add(expense);
        expenseList.add(new Expense(2, 2,true, 2));
    }

    @Mock
    private ExpenseDao expenseDao;
    @InjectMocks
    private ExpenseService expenseService;

    @Test
    public void shouldReturnExpenseById() {
        when(expenseDao.findById(1)).thenReturn(expense);
        Expense actual = expenseService.findById(1);
        Expense expected = expense;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllExpenses() {
        when(expenseDao.findAll()).thenReturn(expenseList);
        List<Expense> actual = expenseService.findAll();
        List<Expense> expected = expenseList;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnExpensesByUserId() {
        expenseList.remove(1);
        when(expenseDao.findExpensesByUserId(1)).thenReturn(expenseList);
        List<Expense> actual = expenseService.findExpensesByUserId(1);
        List<Expense> expected = expenseList;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnExpensesByTariffId() {
        expenseList.remove(1);
        when(expenseDao.findExpensesByTariffId(1)).thenReturn(expenseList);
        List<Expense> actual = expenseService.findExpensesByTariffId(1);
        List<Expense> expected = expenseList;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnExpensesByWeightId() {
        expenseList.remove(1);
        when(expenseDao.findExpensesByWeightId(1)).thenReturn(expenseList);
        List<Expense> actual = expenseService.findExpensesByWeightId(1);
        List<Expense> expected = expenseList;
        Assert.assertEquals(expected, actual);
    }
}
