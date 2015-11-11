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
public class Purchase {

    private String customerName;
    private double subTotal;
    private PaymentMethods paymentMethod; //cash, credit, debit
    private double discount;
    

    public Purchase(String customerName, double subTotal, PaymentMethods paymentMethod) {
        this.customerName = customerName;
        this.subTotal = subTotal;
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public double getDiscount() {
        return discount;
    }

    public void setCustomer_name(String customer_name) {
        this.customerName = customer_name;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setPaymentMethod(PaymentMethods paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Purchase{" + "customer_name=" + customerName + ", subTotal=" + subTotal + ", paymentMethod=" + paymentMethod + ", discount=" + discount + '}';
    }

}
