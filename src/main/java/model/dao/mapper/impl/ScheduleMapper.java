package model.dao.mapper.impl;

import model.dao.mapper.ObjectMapper;
import model.entity.Schedule;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleMapper implements ObjectMapper<Schedule> {
    @Override
    public Schedule mapResultSetToEntity(ResultSet rs) throws SQLException {
        Schedule schedule = new Schedule();
        schedule.setId(rs.getInt("id"));
        schedule.setTimeBegin(rs.getTime("timeBegin").toLocalTime());
        schedule.setTimeEnd(rs.getTime("timeEnd").toLocalTime());
        return schedule;
    }
}
