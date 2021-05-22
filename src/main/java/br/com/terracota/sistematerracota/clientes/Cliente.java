package br.com.terracota.sistematerracota.clientes;

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
    private String origemCliente;

    public Cliente(String nome, String telefone, String email, String documento, String origemCliente) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.documento = documento;
        this.origemCliente = origemCliente;
    }

    @Deprecated
    public Cliente() {
    }
}
