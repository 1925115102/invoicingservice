package edu.iu.c322.invoicingservice.controller;

import edu.iu.c322.invoicingservice.model.Order;
import edu.iu.c322.invoicingservice.model.Invoice;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

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
        invoice.setPayment(order.payment());
        // add the rest of the data items
        return invoice;
    }
}