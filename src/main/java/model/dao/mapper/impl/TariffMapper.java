package model.dao.mapper.impl;

import model.dao.mapper.ObjectMapper;
import model.entity.Tariff;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TariffMapper implements ObjectMapper<Tariff> {
    @Override
    public Tariff mapResultSetToEntity(ResultSet rs) throws SQLException {
        Tariff tariff = new Tariff();
        tariff.setId(rs.getInt("id"));
        tariff.setValue(rs.getInt("value"));
        tariff.setPrice(rs.getLong("price"));
        tariff.setDepartmentFromId(rs.getInt("departmentFromId"));
        tariff.setDepartmentToId(rs.getInt("departmentToId"));
        tariff.setDeliveryTypeId(rs.getInt("deliveryTypeId"));
        return tariff;
    }
}
