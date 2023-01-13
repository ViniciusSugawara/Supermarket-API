package br.com.supermarketapi.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public abstract class BaseDTO {
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDTO baseDTO = (BaseDTO) o;
        return Objects.equals(id, baseDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
