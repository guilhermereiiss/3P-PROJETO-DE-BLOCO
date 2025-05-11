package org.example.model;

import org.example.enums.OrderStatus;
import org.example.enums.PaymentMethod;

import java.time.LocalDateTime;

public class Transaction {

    private PaymentMethod paymentMethod;
    private OrderStatus orderStatus;

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    private LocalDateTime dateTime;
    Reservation reservation;

    public Transaction(PaymentMethod paymentMethod, Reservation reservation) {
        this.paymentMethod = paymentMethod;
        this.reservation = reservation;
    }



}
