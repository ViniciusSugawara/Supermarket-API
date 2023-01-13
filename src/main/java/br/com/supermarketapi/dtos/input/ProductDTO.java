package br.com.supermarketapi.dtos.input;

import br.com.supermarketapi.dtos.BaseDTO;
import br.com.supermarketapi.models.Category;
import br.com.supermarketapi.models.ClientList;
import br.com.supermarketapi.models.OrderDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
public class ProductDTO extends BaseDTO {
    private String name;
    private String description;
    private String image;
    private int quantity;
    private boolean status;
    private Category category;
    private Long price;
    private Set<OrderDetails> orderDetails = new HashSet<>();
}
