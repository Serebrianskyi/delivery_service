package model.dao.mapper.impl;

import model.dao.mapper.ObjectMapper;
import model.entity.Request;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestMapper implements ObjectMapper<Request> {
    @Override
    public Request mapResultSetToEntity(ResultSet rs) throws SQLException {
        Request request = new Request();
        request.setId(rs.getInt("id"));
        request.setDate(rs.getDate("date").toLocalDate());
        request.setUserId(rs.getInt("userId"));
        request.setTariffId(rs.getInt("tariffId"));
        request.setWeightId(rs.getInt("weightId"));
        return request;
    }
}
