package br.com.terracota.sistematerracota.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existByEmail(String email);

    boolean existByDocumento(String documento);
}
