package br.com.supermarketapi.models;

import jakarta.persistence.*;

import java.util.List;

// Represents a list of products, which will be manipulated by the Client user
@Entity
public class ListOfProducts{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    @JoinTable(name = "products_listofproducts", joinColumns = @JoinColumn(name = "listofproducts_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
