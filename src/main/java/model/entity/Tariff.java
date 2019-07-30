package model.entity;

import java.util.Objects;

public class Tariff {
    private Integer id;
    private int value;
    private long price;
    private Integer departmentFromId;
    private Integer departmentToId;
    private Integer deliveryTypeId;

    public Tariff(Integer id, int value, long price, Integer departmentFromId, Integer departmentToId, Integer deliveryTypeId) {
        this.id = id;
        this.value = value;
        this.price = price;
        this.departmentFromId = departmentFromId;
        this.departmentToId = departmentToId;
        this.deliveryTypeId = deliveryTypeId;
    }

    public Tariff() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Integer getDepartmentFromId() {
        return departmentFromId;
    }

    public void setDepartmentFromId(Integer departmentFromId) {
        this.departmentFromId = departmentFromId;
    }

    public Integer getDepartmentToId() {
        return departmentToId;
    }

    public void setDepartmentToId(Integer departmentToId) {
        this.departmentToId = departmentToId;
    }

    public Integer getDeliveryTypeId() {
        return deliveryTypeId;
    }

    public void setDeliveryTypeId(Integer deliveryTypeId) {
        this.deliveryTypeId = deliveryTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return value == tariff.value &&
                price == tariff.price &&
                id.equals(tariff.id) &&
                departmentFromId.equals(tariff.departmentFromId) &&
                departmentToId.equals(tariff.departmentToId) &&
                deliveryTypeId.equals(tariff.deliveryTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, price, departmentFromId, departmentToId, deliveryTypeId);
    }
}
