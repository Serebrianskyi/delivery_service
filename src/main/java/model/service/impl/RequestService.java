package model.service.impl;

import model.dao.FactoryDao;
import model.dao.RequestDao;
import model.entity.Request;
import model.service.GenericService;
import org.apache.log4j.Logger;

import java.util.List;

public class RequestService implements GenericService<Request> {
    private Logger logger = Logger.getLogger(RequestService.class);
    private FactoryDao factoryDao = FactoryDao.getInstance();
    private RequestDao requestDao = factoryDao.createRequestDao();

    @Override
    public void create(Request entity) {
        requestDao.create(entity);
    }

    @Override
    public Request findById(int id) {
        return requestDao.findById(id);
    }

    @Override
    public List<Request> findAll() {
        return requestDao.findAll();
    }

    public List<Request> findRequestsByUserId(int id) {
        return requestDao.findRequestsByUserId(id);
    }

    public List<Request> findRequestsByTariffId(int id) {
        return requestDao.findRequestsByTariffId(id);
    }

    public List<Request> findRequestsByWeightId(int id) {
        return requestDao.findRequestsByWeightId(id);
    }

    @Override
    public void update(Request entity) {
        requestDao.update(entity);
    }

    @Override
    public void delete(int id) {
        requestDao.delete(id);
    }
}
