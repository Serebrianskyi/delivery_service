package model.dao;

import model.entity.DeliveryType;

public interface DeliveryTypeDao extends GenericDao<DeliveryType> {
    DeliveryType findDeliveryTypeByName(String name);

    boolean deliveryTypeIsCreated(DeliveryType deliveryType);
}
