package model.entity;

import java.time.LocalTime;
import java.util.Objects;

public class Schedule {
    private Integer id;
    private LocalTime timeBegin;
    private LocalTime timeEnd;

    public Schedule(Integer id, LocalTime timeBegin, LocalTime timeEnd) {
        this.id = id;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
    }

    public Schedule() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(LocalTime timeBegin) {
        this.timeBegin = timeBegin;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return timeBegin.equals(schedule.timeBegin) &&
                timeEnd.equals(schedule.timeEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeBegin, timeEnd);
    }
}
