package br.com.supermarketapi.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class BaseDTO {
    @EqualsAndHashCode.Include
    private Long id;
}
