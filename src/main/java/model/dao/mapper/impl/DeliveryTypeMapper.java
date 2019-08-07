package model.dao.mapper.impl;

import model.dao.mapper.ObjectMapper;
import model.entity.DeliveryType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryTypeMapper implements ObjectMapper<DeliveryType> {
    @Override
    public DeliveryType mapResultSetToEntity(ResultSet rs) throws SQLException {
        DeliveryType deliveryType = new DeliveryType();
        deliveryType.setId(rs.getInt("id"));
        deliveryType.setName(rs.getString("name"));
        deliveryType.setDescription(rs.getString("description"));
        return deliveryType;
    }
}
