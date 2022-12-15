package br.com.supermarketapi.models;

import java.util.List;

// Represents a list of products, which will be manipulated by the Client user
public class ListOfProducts extends BaseEntity {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
