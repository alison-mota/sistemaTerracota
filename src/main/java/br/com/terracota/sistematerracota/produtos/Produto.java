package br.com.terracota.sistematerracota.produtos;

import br.com.terracota.sistematerracota.empresas.Empresa;
import br.com.terracota.sistematerracota.fornecedores.Fornecedor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;
    @NotNull
    @ManyToOne
    private Empresa empresa;
    @NotBlank
    private String nome;
    @NotNull
    private Long estoque;
    @NotNull
    private BigDecimal valorVenda;
    private BigDecimal valorCusto;
    private String linkFoto;
    @ManyToOne
    private Fornecedor fornecedor;
    @Column(updatable = false)
    private final LocalDateTime dataCriacao = LocalDateTime.now();
    private Boolean ativo = Boolean.TRUE;

    public Produto(Empresa empresa, String nome, Long estoque, BigDecimal valorVenda, BigDecimal valorCusto, String linkFoto) {
        this.empresa = empresa;
        this.nome = nome;
        this.estoque = estoque;
        this.valorVenda = valorVenda;
        this.valorCusto = valorCusto;
        this.linkFoto = linkFoto;
    }

    @Deprecated
    public Produto() {
    }
}
