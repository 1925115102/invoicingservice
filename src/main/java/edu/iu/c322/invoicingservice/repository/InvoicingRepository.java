package edu.iu.c322.invoicingservice.repository;

import edu.iu.c322.invoicingservice.model.Item;
import edu.iu.c322.invoicingservice.model.Order;
import edu.iu.c322.invoicingservice.model.Update;
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
        throw new IllegalStateException("order with this id does not exist in the system.");
    }

    public void update(Update update, int id){
        Order x = findById(id);
        if (x != null){
            for (Item item : x.getItems()) {
                if (item.getId() == update.getItemId()) {
                    item.setStatus(update.getStatus());
                    return;
                }
            }
        } else {
            throw new IllegalStateException("order with this id does not exist in the system");
        }
    }

    private Order getOrderById(int id) {
        return orders.stream().filter(x -> x.getCustomerId() == id).findAny().orElse(null);
    }
}
