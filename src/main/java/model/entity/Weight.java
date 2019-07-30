package model.entity;

import java.util.Objects;

public class Weight {
    private Integer id;
    private double value;
    private double coefficient;

    public Weight(Integer id, double value, double coefficient) {
        this.id = id;
        this.value = value;
        this.coefficient = coefficient;
    }

    public Weight() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        return Double.compare(weight.value, value) == 0 &&
                Double.compare(weight.coefficient, coefficient) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, coefficient);
    }
}
