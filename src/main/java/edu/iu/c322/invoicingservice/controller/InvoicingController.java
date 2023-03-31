package edu.iu.c322.invoicingservice.controller;

import edu.iu.c322.invoicingservice.model.Order;
import edu.iu.c322.invoicingservice.model.Update;
import edu.iu.c322.invoicingservice.repository.InvoicingRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoicingController {
    private InvoicingRepository repository;

    public InvoicingController(InvoicingRepository repository) {
        this.repository = repository;
    }

    // Get localhost:8080/orders
    @GetMapping("/{id}")
    public Order findById(@PathVariable int id){
        return repository.findById(id);
    }


    // PUT localhost:8080/order/2
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Update update, @PathVariable int id){
        repository.update(update, id);
    }

}
