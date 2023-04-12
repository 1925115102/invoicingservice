package edu.iu.c322.invoicingservice.controller;

import edu.iu.c322.invoicingservice.model.InvoiceItem;
import edu.iu.c322.invoicingservice.model.Item;
import edu.iu.c322.invoicingservice.model.Order;
import edu.iu.c322.invoicingservice.model.Invoice;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

@RestController
@RequestMapping("/invoices")
public class InvoicingController {

    private final WebClient orderService;

    public InvoicingController(WebClient.Builder webClientBuilder) {
        orderService = webClientBuilder.baseUrl("http://localhost:8083").build();
    }


    @GetMapping("/{orderId}")
    public Invoice findByOrderId(@PathVariable int orderId) {
        Order order = orderService.get().uri("/orders/order/{orderId}", orderId)
                .retrieve()
                .bodyToMono(Order.class).block();
        Invoice invoice = new Invoice();
        invoice.setTotal(order.total());
        invoice.setOrderPlaced(new Date());
        invoice.setPayment(order.payment());
        // add the rest of the data items
        List<InvoiceItem> itemList = new ArrayList<>();
        for (Item item: order.items()){
            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.setStatus(item.status());
            invoiceItem.setOn(new Date());
            invoiceItem.setAddress(order.shippingAddress());
            List<Item> itemSubList = new ArrayList<>();
            itemSubList.add(item);
            invoiceItem.setItems(itemSubList);
            itemList.add(invoiceItem);
        }
        invoice.setInvoiceItems(itemList);
        return invoice;
    }
}