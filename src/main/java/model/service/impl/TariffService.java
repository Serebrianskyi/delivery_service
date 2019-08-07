package model.service.impl;

import model.dao.FactoryDao;
import model.dao.TariffDao;
import model.entity.Tariff;
import model.service.GenericService;
import org.apache.log4j.Logger;

import java.util.List;

public class TariffService implements GenericService<Tariff> {
    private Logger logger = Logger.getLogger(TariffService.class);
    private FactoryDao factoryDao = FactoryDao.getInstance();
    private TariffDao tariffDao = factoryDao.createTariffDao();

    @Override
    public void create(Tariff entity) {
        tariffDao.create(entity);
    }

    @Override
    public Tariff findById(int id) {
        return tariffDao.findById(id);
    }

    @Override
    public List<Tariff> findAll() {
        return tariffDao.findAll();
    }

    @Override
    public void update(Tariff entity) {
        tariffDao.update(entity);
    }

    @Override
    public void delete(int id) {
        tariffDao.delete(id);
    }

    public Tariff findTariffByDepartmentFromAndDepartmentToAndDeliveryType(Integer from, Integer to,
                                                                           Integer deliveryType){
        return tariffDao.findTariffByDepartmentFromAndDepartmentToAndDeliveryType(from,to,deliveryType);
    }

    public boolean tariffIsCreated(Tariff tariff){
        return tariffDao.tariffIsCreated(tariff);
    }
}
