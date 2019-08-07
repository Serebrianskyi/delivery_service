package model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ObjectMapper<T> {
    T mapResultSetToEntity(ResultSet rs) throws SQLException;
}
