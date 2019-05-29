package com.deunacabeca.api.model.filter;

public abstract class AbstractFilter {
    private int quantity = 10;
    private int page = 0;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
