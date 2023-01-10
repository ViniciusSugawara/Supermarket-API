package br.com.supermarketapi.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

//Represents the product entity, which will be manipulated by the Admin user
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
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
    @OneToMany(mappedBy = "product_order")
    private Set<OrderDetails> orderDetails = new HashSet<>();
}
