package br.com.supermarketapi.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//Represents the product entity, which will be manipulated by the Admin user
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    //Placeholder - Will change to image later
    private String image;
    private int quantity;

    private boolean status;
    @ManyToMany
    @JoinTable(name = "products_listOfProducts", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "listOfProduct_id"))
    private List<ListOfProduct> productList = new ArrayList<>();

    public Product() {
    }

    public Product(String name, String description, String image, int quantity, boolean status) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.quantity = quantity;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<ListOfProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<ListOfProduct> productList) {
        this.productList = productList;
    }
}
