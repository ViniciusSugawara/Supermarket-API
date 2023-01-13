package br.com.supermarketapi.dtos.input;

import br.com.supermarketapi.dtos.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsDTO extends BaseDTO {
    private ProductDTO product_order;
    private ClientListDTO clientList;
    private int productQuantity;

}
