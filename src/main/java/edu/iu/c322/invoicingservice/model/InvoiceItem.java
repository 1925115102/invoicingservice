package edu.iu.c322.invoicingservice.model;

import java.util.Date;
import java.util.List;

public class InvoiceItem {
    private String status;
    private Date on;

    private Address address;

    private List<Item> items;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOn() {
        return on;
    }

    public void setOn(Date on) {
        this.on = on;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}