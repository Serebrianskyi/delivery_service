package model.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Request {
    private Integer id;
    private LocalDate date;
    private Integer tariffId;
    private Integer weightId;
    private Integer userId;

    public Request(Integer id, LocalDate date, Integer tariffId, Integer weightId, Integer userId) {
        this.id = id;
        this.date = date;
        this.tariffId = tariffId;
        this.weightId = weightId;
        this.userId = userId;
    }

    public Request() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getTariffId() {
        return tariffId;
    }

    public void setTariffId(Integer tariffId) {
        this.tariffId = tariffId;
    }

    public Integer getWeightId() {
        return weightId;
    }

    public void setWeightId(Integer weightId) {
        this.weightId = weightId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return date.equals(request.date)  &&
                tariffId.equals(request.tariffId) &&
                weightId.equals(request.weightId) &&
                userId.equals(request.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, tariffId, weightId, userId);
    }
}

