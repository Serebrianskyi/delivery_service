package model.dao;

import model.entity.Request;

import java.util.List;

public interface RequestDao extends GenericDao<Request> {
    List<Request> findRequestsByUserId(int id);

    List<Request> findRequestsByTariffId(int id);

    List<Request> findRequestsByWeightId(int id);
}
