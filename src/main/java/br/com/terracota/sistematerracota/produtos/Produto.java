package br.com.terracota.sistematerracota.produtos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    private Loja loja;
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
