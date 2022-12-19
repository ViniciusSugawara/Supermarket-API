package br.com.supermarketapi.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// Represents a list of products, which will be manipulated by the Client user
@Entity
public class ListOfProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name = "products_listOfProducts", joinColumns = @JoinColumn(name = "listOfProduct_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> shoplist = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getShoplist() {
        return shoplist;
    }

    public void setShoplist(List<Product> products) {
        this.shoplist = products;
    }
}
