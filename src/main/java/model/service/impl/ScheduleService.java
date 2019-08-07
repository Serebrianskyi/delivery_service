package model.service.impl;

import model.dao.FactoryDao;
import model.dao.ScheduleDao;
import model.entity.Schedule;
import model.service.GenericService;
import org.apache.log4j.Logger;

import java.time.LocalTime;
import java.util.List;

public class ScheduleService implements GenericService<Schedule> {
    private Logger logger = Logger.getLogger(ScheduleService.class);
    private FactoryDao factoryDao = FactoryDao.getInstance();
    private ScheduleDao scheduleDao = factoryDao.createScheduleDao();

    @Override
    public void create(Schedule entity) {
        scheduleDao.create(entity);
    }

    @Override
    public Schedule findById(int id) {
        return scheduleDao.findById(id);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleDao.findAll();
    }

    @Override
    public void update(Schedule entity) {
        scheduleDao.update(entity);
    }

    @Override
    public void delete(int id) {
        scheduleDao.delete(id);
    }

    public Schedule findScheduleByTimeBeginAndTimeEnd(LocalTime timeBegin, LocalTime timeEnd){
        return scheduleDao.findScheduleByTimeBeginAndTimeEnd(timeBegin,timeEnd);
    }

    public boolean scheduleIsCreated(Schedule schedule){
        return scheduleDao.scheduleIsCreated(schedule);
    }
}
