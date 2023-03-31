package edu.iu.c322.invoicingservice.model;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Objects;


public class Order {
    private int customerId;
    private int orderId;

    private double total;
    private @Valid Address shippingAddress;

    private List<@Valid Item> items;

    private @Valid Payment payment;
    private String status;

    public Order(int customerId, double total, Address shippingAddress, List<Item> items, Payment payment) {
        this.customerId = customerId;
        this.total = total;
        this.shippingAddress = shippingAddress;
        this.items = items;
        for (int i = 0; i < items.size(); i++){
            items.get(i).setId(i+1);
        }
        this.payment = payment;
        this.status = "ordered";
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setItems(List<Item> itemGroup) {
        for (int i = 0; i < itemGroup.size();i++) {
            Item temp = itemGroup.get(i);
            temp.setId(i+1);
            items.add(temp);
        }
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
