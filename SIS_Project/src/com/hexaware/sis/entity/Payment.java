package com.hexaware.sis.entity;

import java.time.LocalDate;

public class Payment {
    private int paymentId;
    private Student student;
    private double amount;
    private LocalDate paymentDate;

    public Payment(int paymentId, Student student, double amount, LocalDate paymentDate) {
        this.paymentId = paymentId;
        this.student = student;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    // Getters
    public int getPaymentId() { return paymentId; }
    public Student getStudent() { return student; }
    public double getAmount() { return amount; }
    public LocalDate getPaymentDate() { return paymentDate; }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
