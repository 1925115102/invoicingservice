package edu.iu.c322.invoicingservice.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

public record Payment(int id,
                      String method,
                      String number,
                      Address billingAddress) {
}
