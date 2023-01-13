package br.com.supermarketapi.dtos.input;

import br.com.supermarketapi.dtos.BaseDTO;
import br.com.supermarketapi.models.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
public class CategoryDTO extends BaseDTO {
    private String name;
    private Set<Product> products = new HashSet<>();
}
