package br.com.supermarketapi.repositories;

import br.com.supermarketapi.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
