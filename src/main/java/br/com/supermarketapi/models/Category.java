package br.com.supermarketapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Category extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();
}
