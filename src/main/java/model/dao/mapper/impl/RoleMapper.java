package model.dao.mapper.impl;

import model.dao.mapper.ObjectMapper;
import model.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements ObjectMapper<Role> {
    @Override
    public Role mapResultSetToEntity(ResultSet rs) throws SQLException {
        Role role = new Role();
        role.setId(rs.getInt("id"));
        role.setName(rs.getString("name"));
        role.setDescription(rs.getString("description"));
        return role;
    }
}
