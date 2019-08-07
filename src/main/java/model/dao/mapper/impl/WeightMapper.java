package model.dao.mapper.impl;

import model.dao.mapper.ObjectMapper;
import model.entity.Weight;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WeightMapper implements ObjectMapper<Weight> {
    @Override
    public Weight mapResultSetToEntity(ResultSet rs) throws SQLException {
        Weight weight = new Weight();
        weight.setId(rs.getInt("id"));
        weight.setValue(rs.getDouble("value"));
        weight.setCoefficient(rs.getDouble("coefficient"));
        return weight;
    }
}
