package model.service.impl;

import model.dao.DeliveryTypeDao;
import model.entity.DeliveryType;
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
public class DeliveryTypeServiceTest {
    DeliveryType deliveryType;
    List<DeliveryType> deliveryTypeList;

    @Before
    public void setUp() {
        deliveryTypeList = new ArrayList<>();
        deliveryType = new DeliveryType(1, "name1", "description1");
        deliveryTypeList.add(deliveryType);
        deliveryTypeList.add(new DeliveryType(2, "name2", "description2"));
    }

    @Mock
    private DeliveryTypeDao deliveryTypeDao;
    @InjectMocks
    private DeliveryTypeService deliveryTypeService;

    @Test
    public void shouldReturnDeliveryTypeById() {
        when(deliveryTypeDao.findById(1)).thenReturn(deliveryType);
        DeliveryType actual = deliveryTypeService.findById(1);
        DeliveryType expected = deliveryType;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllDeliveryTypes() {
        when(deliveryTypeDao.findAll()).thenReturn(deliveryTypeList);
        List<DeliveryType> actual = deliveryTypeService.findAll();
        List<DeliveryType> expected = deliveryTypeList;
        Assert.assertEquals(expected, actual);
    }
}
