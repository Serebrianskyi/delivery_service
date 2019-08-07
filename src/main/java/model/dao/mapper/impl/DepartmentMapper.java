package model.dao.mapper.impl;

import model.dao.mapper.ObjectMapper;
import model.entity.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper implements ObjectMapper<Department> {
    @Override
    public Department mapResultSetToEntity(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("id"));
        department.setTown(rs.getString("town"));
        department.setStreet(rs.getString("street"));
        department.setBuildingNumber(rs.getString("buildingNumber"));
        department.setSheduleId(rs.getInt("scheduleId"));
        return department;
    }
}
