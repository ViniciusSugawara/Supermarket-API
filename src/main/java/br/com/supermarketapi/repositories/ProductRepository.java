package br.com.supermarketapi.repositories;

import br.com.supermarketapi.dtos.ProductIDandName;
import br.com.supermarketapi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p.id, p.name FROM Product p", nativeQuery = true)
    List<ProductIDandName> findAllProductsIdAndName();
}
