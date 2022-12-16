package br.com.supermarketapi.repositories;

import br.com.supermarketapi.models.ListOfProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListOfProductsRepository extends JpaRepository<ListOfProducts, Long> {
}
