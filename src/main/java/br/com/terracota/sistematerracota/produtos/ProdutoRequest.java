package br.com.terracota.sistematerracota.produtos;

import br.com.terracota.sistematerracota.empresas.Empresa;
import br.com.terracota.sistematerracota.fornecedores.Fornecedor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProdutoRequest {

    @NotNull
    private Empresa empresa;
    @NotBlank
    private String nome;
    @NotNull
    private Long estoque;
    @NotNull
    private BigDecimal valorVenda;
    private BigDecimal valorCusto;
    private String linkFoto;
    private Fornecedor fornecedor;
    private Boolean ativo;

    public Produto toModel(Empresa empresa) {
        return new Produto(empresa, nome, estoque, valorVenda, valorCusto, linkFoto);
    }
}
