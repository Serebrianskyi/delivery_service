package model.service.impl;

import model.dao.ScheduleDao;
import model.entity.Schedule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScheduleServiceTest {
    Schedule sechedule;
    List<Schedule> secheduleList;

    @Before
    public void setUp() {
        secheduleList = new ArrayList<>();
        sechedule =
                new Schedule(1, LocalTime.of(1, 1, 1),
                        LocalTime.of(1, 1, 1));
        secheduleList.add(sechedule);
        secheduleList.add(
                new Schedule(2, LocalTime.of(2, 2, 2),
                        LocalTime.of(2, 2, 2)));
    }

    @Mock
    private ScheduleDao secheduleDao;
    @InjectMocks
    private ScheduleService secheduleService;

    @Test
    public void shouldReturnScheduleById() {
        when(secheduleDao.findById(1)).thenReturn(sechedule);
        Schedule actual = secheduleService.findById(1);
        Schedule expected = sechedule;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllSchedules() {
        when(secheduleDao.findAll()).thenReturn(secheduleList);
        List<Schedule> actual = secheduleService.findAll();
        List<Schedule> expected = secheduleList;
        Assert.assertEquals(expected, actual);
    }
}
