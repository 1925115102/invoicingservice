package edu.iu.c322.invoicingservice.repository;

import edu.iu.c322.invoicingservice.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoicingRepository {
    private List<Order> orders = new ArrayList<>();

    public Order findById(int id){
        for(Order order: orders){
            if (order.getCustomerId()==id){
                return order;
            }
        }
        throw new IllegalStateException("customer id is not valid.");
    }

    public void update(Order order, int id){
        Order x = getOrderById(id);
        if (x != null){
            x.setTotal(order.getTotal());
            x.setItems(order.getItems());
            x.setPayment(order.getPayment());
            x.setShippingAddress(order.getShippingAddress());
        } else {
            throw new IllegalStateException("customer id is not valid.");
        }
    }

    private Order getOrderById(int id) {
        return orders.stream().filter(x -> x.getCustomerId() == id).findAny().orElse(null);
    }
}
