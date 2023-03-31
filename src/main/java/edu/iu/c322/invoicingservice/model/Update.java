package edu.iu.c322.invoicingservice.model;

import jakarta.validation.constraints.NotEmpty;

public class Update {
    private int itemId;
    @NotEmpty(message = "status should not be empty")
    private String status;

    public Update(int orderId, int itemId, String reason) {
        this.itemId = itemId;
        this.status = reason;
    }


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
