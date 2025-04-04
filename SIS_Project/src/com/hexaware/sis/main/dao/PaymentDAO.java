package com.hexaware.sis.main.dao;

import com.hexaware.sis.entity.Payment;
import com.hexaware.sis.exception.PaymentNotFoundException;

import java.util.*;

public class PaymentDAO {
    // Simulated database using a List
    private static List<Payment> payments = new ArrayList<>();
    
    // Create: Adds a new payment record
    public void addPayment(Payment payment) {
        payments.add(payment);
        System.out.println("Payment recorded: $" + payment.getAmount() + " for Student ID " + payment.getStudent().getStudentId());
    }

    // Read: Retrieves all payments for a specific student
    public List<Payment> getPaymentsByStudentId(int studentId) {
        List<Payment> result = new ArrayList<>();
        for (Payment p : payments) {
            if (p.getStudent().getStudentId() == studentId) {
                result.add(p);
            }
        }
        if (result.isEmpty()) {
            throw new PaymentNotFoundException("No payments found for Student ID: " + studentId);
        }
        return result;
    }
    
    // Read: Retrieve all payment records
    public List<Payment> getAllPayments() {
        return new ArrayList<>(payments);
    }

    // Update: Modify an existing payment record
    public void updatePayment(int paymentId, double newAmount) {
        for (Payment p : payments) {
            if (p.getPaymentId() == paymentId) {
                p.setAmount(newAmount);
                System.out.println("Payment updated: ID " + paymentId + ", New Amount: $" + newAmount);
                return;
            }
        }
        throw new PaymentNotFoundException("Payment not found with ID: " + paymentId);
    }

    // Delete: Remove a payment record
    public void deletePayment(int paymentId) {
        Iterator<Payment> iterator = payments.iterator();
        while (iterator.hasNext()) {
            Payment p = iterator.next();
            if (p.getPaymentId() == paymentId) {
                iterator.remove();
                System.out.println("Payment deleted with ID: " + paymentId);
                return;
            }
        }
        throw new PaymentNotFoundException("Payment not found with ID: " + paymentId);
    }
}
