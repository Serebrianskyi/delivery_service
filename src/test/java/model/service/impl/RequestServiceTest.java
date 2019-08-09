package model.service.impl;

import model.dao.RequestDao;
import model.entity.Request;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RequestServiceTest {
    Request request;
    List<Request> requestList;

    @Before
    public void setUp() {
        requestList = new ArrayList<>();
        request = new Request(1, LocalDate.now(), 1, 1, 1);
        requestList.add(request);
        requestList.add(new Request(2, LocalDate.now(), 2, 2, 2));
    }

    @Mock
    private RequestDao requestDao;
    @InjectMocks
    private RequestService requestService;

    @Test
    public void shouldReturnRequestById() {
        when(requestDao.findById(1)).thenReturn(request);
        Request actual = requestService.findById(1);
        Request expected = request;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllRequests() {
        when(requestDao.findAll()).thenReturn(requestList);
        List<Request> actual = requestService.findAll();
        List<Request> expected = requestList;
        Assert.assertEquals(expected, actual);
    }

    public void shouldReturnExpensesByUserId() {
        requestList.remove(1);
        when(requestDao.findRequestsByUserId(1)).thenReturn(requestList);
        List<Request> actual = requestService.findRequestsByUserId(1);
        List<Request> expected = requestList;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnExpensesByTariffId() {
        requestList.remove(1);
        when(requestDao.findRequestsByTariffId(1)).thenReturn(requestList);
        List<Request> actual = requestService.findRequestsByTariffId(1);
        List<Request> expected = requestList;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnExpensesByWeightId() {
        requestList.remove(1);
        when(requestDao.findRequestsByWeightId(1)).thenReturn(requestList);
        List<Request> actual = requestService.findRequestsByWeightId(1);
        List<Request> expected = requestList;
        Assert.assertEquals(expected, actual);
    }
}
