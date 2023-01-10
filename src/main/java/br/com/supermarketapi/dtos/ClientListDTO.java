package br.com.supermarketapi.dtos;

import br.com.supermarketapi.models.OrderDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClientListDTO extends BaseDTO {
    private String clientName;
    @JsonIgnore
    private Set<OrderDetails> orderDetails;
}
