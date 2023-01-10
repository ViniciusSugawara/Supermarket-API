package br.com.supermarketapi.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

// Represents a list of products, which will be manipulated by the Client user
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClientList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String clientName;
    @OneToMany(mappedBy = "clientList", cascade = CascadeType.ALL)
    private Set<OrderDetails> orderDetails = new HashSet<>();

    public ClientList(String clientName){
        this.clientName = clientName;
    }
}
