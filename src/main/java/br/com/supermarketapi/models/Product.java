package br.com.supermarketapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

//Represents the product entity, which will be manipulated by the Admin user
@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Product extends BaseEntity{
    @NonNull
    private String name;
    @NonNull
    private String description;

    //Placeholder - Will change to image later
    @NonNull
    private String image;
    @NonNull
    private int quantity;
    @NonNull
    private boolean status;
    @ManyToOne
    @NonNull
    private Category category;
    @OneToMany(mappedBy = "product_order")
    private Set<OrderDetails> orderDetails = new HashSet<>();
}
