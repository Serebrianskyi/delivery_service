package model.dao;


import model.entity.Tariff;

public interface TariffDao extends GenericDao<Tariff> {
    Tariff findTariffByDepartmentFromAndDepartmentToAndDeliveryType(Integer from, Integer to, Integer deliveryType);

    boolean tariffIsCreated(Tariff tariff);
}
