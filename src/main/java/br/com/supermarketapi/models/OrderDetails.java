package br.com.supermarketapi.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne
    private Product product_order;

    @ManyToOne
    private ClientList clientList;

    @Column(name = "quantity")
    private int productQuantity;

}
