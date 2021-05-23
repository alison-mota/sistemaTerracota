package br.com.terracota.sistematerracota.clientes;

import br.com.terracota.sistematerracota.empresas.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByEmail(String email);

    boolean existsByDocumento(String documento);

    boolean existsByEmpresa(Empresa empresa);
}
