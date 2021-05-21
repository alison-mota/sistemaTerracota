package br.com.terracota.sistematerracota.clientes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository {
    boolean existByEmail(String email);

    boolean existByDocumento(String documento);
}
