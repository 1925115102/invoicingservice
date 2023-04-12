package edu.iu.c322.invoicingservice.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

public record Item(int id,
                        String name,
                        int quantity,
                        float price,
                        String status) {
}