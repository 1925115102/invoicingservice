package edu.iu.c322.invoicingservice.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

public class Payment {
    @NotEmpty(message = "method cannot be empty.")
    private String method;
    @NotEmpty(message = "number cannot be empty.")
    private String number;
    private Address billingAddress;

    public Payment(String method, String number, Address billingAddress) {
        this.method = method;
        this.number = number;
        this.billingAddress = billingAddress;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setShippingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return method.equals(payment.method) && number.equals(payment.number) && billingAddress.equals(payment.billingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, number, billingAddress);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "method='" + method + '\'' +
                ", number='" + number + '\'' +
                ", shippingAddress=" + billingAddress +
                '}';
    }
}
