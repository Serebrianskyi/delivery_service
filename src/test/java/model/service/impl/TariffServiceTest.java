package model.service.impl;

import model.dao.TariffDao;
import model.entity.Tariff;
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
public class TariffServiceTest {
    Tariff tariff;
    List<Tariff> tariffList;

    @Before
    public void setUp() {
        tariffList = new ArrayList<>();
        tariff = new Tariff(1,1,1,1,1,1);
        tariffList.add(tariff);
        tariffList.add(new Tariff(2, 2, 2,2,2,2));
    }

    @Mock
    private TariffDao tariffDao;
    @InjectMocks
    private TariffService tariffService;

    @Test
    public void shouldReturnTariffById() {
        when(tariffDao.findById(1)).thenReturn(tariff);
        Tariff actual = tariffService.findById(1);
        Tariff expected = tariff;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllTariffs() {
        when(tariffDao.findAll()).thenReturn(tariffList);
        List<Tariff> actual = tariffService.findAll();
        List<Tariff> expected = tariffList;
        Assert.assertEquals(expected, actual);
    }
}
