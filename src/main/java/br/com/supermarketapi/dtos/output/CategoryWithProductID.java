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
public class CategoryWithProductID extends BaseDTO {
    private String name;
    private Set<Long> products_id = new HashSet<>();
}
