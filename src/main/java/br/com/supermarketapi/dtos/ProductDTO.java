package br.com.supermarketapi.dtos;

import br.com.supermarketapi.models.ClientList;
import br.com.supermarketapi.models.OrderDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductDTO extends BaseDTO {
    private String name;
    private String description;
    private String image;
    private int quantity;
    private boolean status;
    @JsonIgnore
    private Set<OrderDetails> orderDetails = new HashSet<>();
}
