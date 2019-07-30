package model.entity;

import java.util.Objects;

public class Expense {
    private Integer id;
    private long price;
    private boolean isPaid;
    private Integer requestId;

    public Expense(Integer id, long price,boolean isPaid, Integer requestId) {
        this.id = id;
        this.price = price;
        this.isPaid = isPaid;
        this.requestId = requestId;
    }

    public Expense() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return price == expense.price &&
                isPaid == expense.isPaid &&
                id.equals(expense.id) &&
                requestId.equals(expense.requestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, isPaid, requestId);
    }
}
