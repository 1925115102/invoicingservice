package edu.iu.c322.invoicingservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping
@RestController
public class GreetingController {


    // Get https.localhost:8080
    @GetMapping()
    public String greeting(){
        return "Greetings!!";
    }
}
