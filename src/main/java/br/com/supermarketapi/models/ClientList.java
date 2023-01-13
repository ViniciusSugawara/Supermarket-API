package br.com.supermarketapi.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

// Represents a list of products, which will be manipulated by the Client user
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClientList extends BaseEntity{

    private String clientName;
    @OneToMany(mappedBy = "clientList", cascade = CascadeType.ALL)
    private Set<OrderDetails> orderDetails = new HashSet<>();

    public ClientList(String clientName){
        this.clientName = clientName;
    }
}
