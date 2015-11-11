/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataModel;

/**
 *
 * @author wainwetun
 */
public class PotentialCustomer {
    private String customerName;
    private double creditLimit;
    
    public PotentialCustomer(String customerName, double creditLimit){
        this.customerName = customerName;
        this.creditLimit = creditLimit;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "PotentialCustomer{" + "customerName=" + customerName + ", creditLimit=" + creditLimit + '}';
    }
    
    
}
