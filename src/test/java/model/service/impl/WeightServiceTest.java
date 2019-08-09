package model.service.impl;

import model.dao.WeightDao;
import model.entity.Weight;
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
public class WeightServiceTest {
    Weight weight;
    List<Weight> weightList;

    @Before
    public void setUp() {
        weightList = new ArrayList<>();
        weight = new Weight(1, 1, 1);
        weightList.add(weight);
        weightList.add(new Weight(2, 2, 2));
    }

    @Mock
    private WeightDao weightDao;
    @InjectMocks
    private WeightService weightService;

    @Test
    public void shouldReturnWeightById() {
        when(weightDao.findById(1)).thenReturn(weight);
        Weight actual = weightService.findById(1);
        Weight expected = weight;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllWeights() {
        when(weightDao.findAll()).thenReturn(weightList);
        List<Weight> actual = weightService.findAll();
        List<Weight> expected = weightList;
        Assert.assertEquals(expected, actual);
    }
}
