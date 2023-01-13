package br.com.supermarketapi.dtos.output;

import br.com.supermarketapi.dtos.BaseDTO;
import br.com.supermarketapi.dtos.input.ClientListDTO;
import br.com.supermarketapi.dtos.input.ProductDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsWithIDs extends BaseDTO {
    private Long product_order_id;
    private Long clientList_id;
    private int productQuantity;
}
