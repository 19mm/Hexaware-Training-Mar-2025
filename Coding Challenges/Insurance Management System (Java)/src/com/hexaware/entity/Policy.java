package com.hexaware.entity;

public class Policy {
    private int policyId;
    private String policyNumber;
    private String policyType;
    private double premium;

    //Default Constructor
    public Policy() {}

    //Parameterized Constructor
    public Policy(int policyId, String policyNumber, String policyType, double premium)
    {
        this.policyId = policyId;
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.premium = premium;
    }

    //Getter's & Setter's
    public int getPolicyId()
    {
        return policyId;
    }
    
    public void setPolicyId(int policyId)
    {
        this.policyId = policyId;
    }
    
    public String getPolicyNumber()
    {
        return policyNumber;
    }
    
    public void setPolicyNumber(String policyNumber)
    {
        this.policyNumber = policyNumber;
    }
    
    public String getPolicyType()
    {
        return policyType;
    }
    
    public void setPolicyType(String policyType) 
    {
        this.policyType = policyType;
    }
    
    public double getPremium() 
    {
        return premium;
    }
    
    public void setPremium(double premium) 
    {
        this.premium = premium;
    }

    //toString() Method
    @Override
    public String toString() {
        return "Policy{" +
               "policyId=" + policyId +
               ", policyNumber='" + policyNumber + '\'' +
               ", policyType='" + policyType + '\'' +
               ", premium=" + premium +
               '}';
    }
}
