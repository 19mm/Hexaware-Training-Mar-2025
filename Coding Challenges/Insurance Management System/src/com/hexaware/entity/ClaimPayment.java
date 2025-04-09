package com.hexaware.entity;

import java.sql.Date;

public class ClaimPayment {
    private int paymentId;
    private Date paymentDate;
    private double paymentAmount;
    private Client client;
    
    //Default Constructor
    public ClaimPayment() {}
    
  //Parameterized Constructor
    public ClaimPayment(int paymentId, Date paymentDate, double paymentAmount, Client client)
    {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.client = client;
    }

  //Getter's
    public int getPaymentId() 
    {
        return paymentId;
    }
    
    public Date getPaymentDate() 
    {
        return paymentDate;
    }
    
    public double getPaymentAmount() 
    {
        return paymentAmount;
    }
    
    public Client getClient() 
    {
        return client;
    }
    
    //Setter's
    public void setPaymentId(int paymentId) 
    {
        this.paymentId = paymentId;
    }
    
    public void setPaymentDate(Date paymentDate) 
    {
        this.paymentDate = paymentDate;
    }
    
    public void setPaymentAmount(double paymentAmount) 
    {
        this.paymentAmount = paymentAmount;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }

    //toString() Method
    @Override
    public String toString() {
        return "Payment{" +
               "paymentId=" + paymentId +
               ", paymentDate=" + paymentDate +
               ", paymentAmount=" + paymentAmount +
               ", client=" + (client != null ? client.getClientId() : "null") +
               '}';
    }
}
