package edu.iu.c322.invoicingservice.model;

import java.util.List;
import java.util.Objects;

public class Order {
    private int customerId;

    private double total;
    private Address shippingAddress;

    private List<Item> items;

    private Payment payment;

    public Order(int customerId, double total, Address shippingAddress, List<Item> items, Payment payment) {
        this.customerId = customerId;
        this.total = total;
        this.shippingAddress = shippingAddress;
        this.items = items;
        this.payment = payment;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return customerId == order.customerId && Double.compare(order.total, total) == 0 && shippingAddress.equals(order.shippingAddress) && items.equals(order.items) && payment.equals(order.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, total, shippingAddress, items, payment);
    }
}
