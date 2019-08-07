package model.dao.impl;

import model.dao.ScheduleDao;
import model.dao.mapper.impl.ScheduleMapper;
import model.entity.Schedule;
import model.service.PropertyHolder;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

public class ScheduleDaoImpl extends GenericDaoImpl<Schedule> implements ScheduleDao {
    private static Logger logger = Logger.getLogger(ScheduleDaoImpl.class);
    private PropertyHolder propertyHolder = new PropertyHolder();

    ScheduleDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Schedule entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("insert.into.schedule"));
        } catch (SQLException e) {
            logger.error("Cant insert into schedule: " + e);
        }
    }

    @Override
    public Schedule findById(int id) {
        return genericFindById(propertyHolder.getPropValues("select.schedule.by.id"),
                new ScheduleMapper(), logger,id);
    }

    @Override
    public List<Schedule> findAll() {
        return genericFindMany(propertyHolder.getPropValues("select.all.schedule"), new ScheduleMapper(), logger);
    }

    @Override
    public void update(Schedule entity) {
        try {
            genericCreate(entity, propertyHolder.getPropValues("update.schedule"));
        } catch (SQLException e) {
            logger.error("Cant update schedule: " + e);
        }
    }

    void fillCreateStatement(Schedule entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setTime(1, Time.valueOf(entity.getTimeBegin()));
        preparedStatement.setTime(2, Time.valueOf(entity.getTimeEnd()));
    }



    @Override
    public void delete(int id) {
        try {
            genericDelete(id, propertyHolder.getPropValues("delete.from.schedule"));
        } catch (SQLException e) {
            logger.error("Cant delete from schedule: " + e);
        }
    }

    @Override
    public void close() {
    }

    @Override
    public Schedule findScheduleByTimeBeginAndTimeEnd(LocalTime timeBegin, LocalTime timeEnd) {
        return genericFindOne(propertyHolder.getPropValues("select.schedule.by.time.begin.and.time.end"),
                new ScheduleMapper(), logger, String.valueOf(timeBegin),String.valueOf(timeBegin));
    }

    @Override
    public boolean scheduleIsCreated(Schedule schedule) {
        return findScheduleByTimeBeginAndTimeEnd(schedule.getTimeBegin(),schedule.getTimeEnd()) != null;
    }
}
