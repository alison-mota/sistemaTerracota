package br.com.terracota.sistematerracota.cliente;

import br.com.terracota.sistematerracota.anotacoes.CPFOuCNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String documento;
    private String telefone;
    @Email
    @Column(unique = true)
    private String email;

    public Cliente(String nome, String telefone, String email, String documento) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.documento = documento;
    }

    @Deprecated
    public Cliente() {
    }
}
