package br.com.supermarketapi.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderDetailsDTO extends BaseDTO{
    private ProductDTO product_order;
    private ClientListDTO clientList;
    private int productQuantity;
}
