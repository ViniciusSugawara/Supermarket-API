package br.com.supermarketapi.repositories;

import br.com.supermarketapi.models.ListOfProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListOfProductsRepository extends JpaRepository<ListOfProduct, Long> {
}
