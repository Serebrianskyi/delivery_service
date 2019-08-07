package model.service.impl;

import model.dao.FactoryDao;
import model.dao.WeightDao;
import model.entity.Weight;
import model.service.GenericService;
import org.apache.log4j.Logger;

import java.util.List;

public class WeightService implements GenericService<Weight> {
    private Logger logger = Logger.getLogger(WeightService.class);
    private FactoryDao factoryDao = FactoryDao.getInstance();
    private WeightDao weightDao = factoryDao.createWeightDao();

    @Override
    public void create(Weight entity) {
        weightDao.create(entity);
    }

    @Override
    public Weight findById(int id) {
        return weightDao.findById(id);
    }

    @Override
    public List<Weight> findAll() {
        return weightDao.findAll();
    }

    @Override
    public void update(Weight entity) {
        weightDao.update(entity);
    }

    @Override
    public void delete(int id) {
        weightDao.delete(id);
    }

    public Weight findWeightByValueAndCoefficient(double value, double coefficient){
        return weightDao.findWeightByValueAndCoefficient(value,coefficient);
    }

    public Weight findWeightByValue(double value){
        return weightDao.findWeightByValue(value);
    }

    public boolean weightIsCreated(Weight weight){
        return weightDao.weightIsCreated(weight);
    }
}
