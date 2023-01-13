package br.com.supermarketapi.dtos.output;

import br.com.supermarketapi.dtos.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ProductWithOrderID extends BaseDTO {
    private String name;
    private String description;
    private String image;
    private int quantity;
    private boolean status;
    private String category_name;
    private Set<Long> orderDetails_id = new HashSet<>();
}
