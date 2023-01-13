package br.com.supermarketapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderDetails extends BaseEntity{
    @ManyToOne
    private Product product_order;

    @ManyToOne
    private ClientList clientList;

    @Column(name = "quantity")
    private int productQuantity;

}
