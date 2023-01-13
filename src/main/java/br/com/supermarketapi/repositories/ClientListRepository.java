package br.com.supermarketapi.repositories;

import br.com.supermarketapi.models.ClientList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientListRepository extends JpaRepository<ClientList, Long> {
}
