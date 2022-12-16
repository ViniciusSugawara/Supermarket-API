package br.com.supermarketapi.repositories;

import br.com.supermarketapi.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
