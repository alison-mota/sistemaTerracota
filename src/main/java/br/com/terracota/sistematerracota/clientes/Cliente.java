package br.com.terracota.sistematerracota.clientes;

import br.com.terracota.sistematerracota.enderecos.Endereco;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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
    @NotNull
    private Boolean ativo;
    @ManyToOne
    private Endereco endereco;

    public Cliente(String nome, String telefone, String email, String documento, String origemCliente, Boolean ativo) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.documento = documento;
        this.origemCliente = origemCliente;
        this.ativo = ativo;
    }

    @Deprecated
    public Cliente() {
    }
}
