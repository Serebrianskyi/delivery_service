package controller.command;

import model.entity.Schedule;
import model.service.impl.ScheduleService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;

import static java.util.Objects.nonNull;

public class CreateSchedule implements Command {
    private ScheduleService scheduleService;
    private static Logger logger = Logger.getLogger(CreateSchedule.class);

    public CreateSchedule(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LocalTime timeBegin = LocalTime.parse(request.getParameter("timeBegin"));
        LocalTime timeEnd = LocalTime.parse(request.getParameter("timeEnd"));

        if (nonNull(timeBegin) && nonNull(timeEnd)) {
            Schedule schedule = new Schedule();
            schedule.setTimeBegin(timeBegin);
            schedule.setTimeEnd(timeEnd);

            logger.info("Information for create schedule: " + schedule);
            if (!scheduleService.scheduleIsCreated(schedule)) {
                scheduleService.create(schedule);
            }
        }
        return "redirect: home";
    }
}
