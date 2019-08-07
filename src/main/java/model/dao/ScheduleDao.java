package model.dao;

import model.entity.Schedule;

import java.time.LocalTime;

public interface ScheduleDao extends GenericDao<Schedule> {
    Schedule findScheduleByTimeBeginAndTimeEnd(LocalTime timeBegin, LocalTime timeEnd);

    boolean scheduleIsCreated(Schedule schedule);
}
