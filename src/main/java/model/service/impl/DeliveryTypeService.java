package model.service.impl;

import model.dao.DeliveryTypeDao;
import model.dao.FactoryDao;
import model.entity.DeliveryType;
import model.service.GenericService;
import org.apache.log4j.Logger;

import java.util.List;

public class DeliveryTypeService implements GenericService<DeliveryType> {
    private Logger logger = Logger.getLogger(DeliveryTypeService.class);
    private FactoryDao factoryDao = FactoryDao.getInstance();
    private DeliveryTypeDao deliveryTypeDao = factoryDao.createDeliveryTypeDao();

    @Override
    public void create(DeliveryType entity) {
        deliveryTypeDao.create(entity);
    }

    @Override
    public DeliveryType findById(int id) {
        return deliveryTypeDao.findById(id);
    }

    @Override
    public List<DeliveryType> findAll() {
        return deliveryTypeDao.findAll();
    }

    @Override
    public void update(DeliveryType entity) {
        deliveryTypeDao.update(entity);
    }

    @Override
    public void delete(int id) {
        deliveryTypeDao.delete(id);
    }

    public DeliveryType findDeliveryTypeByName(String name){
        return deliveryTypeDao.findDeliveryTypeByName(name);
    }

    public boolean deliveryTypeIsCreated(DeliveryType deliveryType){
        return deliveryTypeDao.deliveryTypeIsCreated(deliveryType);
    }
}
