package org.example.enums;

public enum OrderStatus {
    CREATED,
    AWAITING_PAYMENT,
    PAID,
    IN_PREPARATION,
    SHIPPED,
    DELIVERED,
    CANCELLED;

    public boolean allowsModification() {
        return this == CREATED || this == AWAITING_PAYMENT;
    }

    public boolean isCompleted() {
        return this == DELIVERED;
    }

    public boolean isCancelled() {
        return this == CANCELLED;
    }
}