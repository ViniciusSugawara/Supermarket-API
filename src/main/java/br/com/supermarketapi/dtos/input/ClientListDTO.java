package br.com.supermarketapi.dtos.input;

import br.com.supermarketapi.dtos.BaseDTO;
import br.com.supermarketapi.models.OrderDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ClientListDTO extends BaseDTO {
    private String clientName;
    private Set<OrderDetails> orderDetails;

}
