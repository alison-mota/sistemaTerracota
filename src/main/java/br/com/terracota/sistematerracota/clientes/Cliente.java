package br.com.terracota.sistematerracota.clientes;

import br.com.terracota.sistematerracota.empresas.Empresa;
import br.com.terracota.sistematerracota.enderecos.Endereco;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;
    private String nome;
    private String documento;
    private String telefone;
    @Email
    private String email;
    private String origemCliente;
    private Boolean ativo = Boolean.TRUE;
    @ManyToOne
    private Endereco endereco;
    @NotNull
    @ManyToOne
    private Empresa empresa;
    @Column(updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Cliente(String nome, String telefone, String email, String documento, String origemCliente, Empresa empresa) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.documento = documento;
        this.origemCliente = origemCliente;
        this.empresa = empresa;
    }

    @Deprecated
    public Cliente() {
    }
}
