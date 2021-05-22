package br.com.terracota.sistematerracota.empresas;

import br.com.terracota.sistematerracota.empresas.dadosAdicionais.EnderecoEmpresa;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String nomeFantasia;
    private String razaoSocial;
    @CNPJ
    private String cnpj;
    private String telefone;
    @Email
    private String email;
    private String site;
    @NotNull
    private Boolean ativo;
    @Embedded
    private EnderecoEmpresa enderecoLoja;



    @Deprecated
    public Empresa() {
    }
}
