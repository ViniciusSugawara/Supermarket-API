package br.com.supermarketapi.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//Represents the product entity, which will be manipulated by the Admin user
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    //Placeholder - Will change to image later
    private String image;

    private boolean status;
    @ManyToMany
    @JoinTable(name = "products_listofproducts", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "listofproducts_id"))
    private List<ListOfProducts> listOfProducts = new ArrayList<>();

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
