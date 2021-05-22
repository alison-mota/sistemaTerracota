package br.com.terracota.sistematerracota.produtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProdutoRequest {

    @NotBlank
    private String nome;
    @NotNull
    private Long estoque;
    @NotNull
    private BigDecimal valorVenda;
    private BigDecimal valorCusto;
    private String fornecedor;
    private String linkFoto;
}
