package br.com.terracota.sistematerracota.fornecedores;

import br.com.terracota.sistematerracota.enderecos.Endereco;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private Long id;
    @NotBlank
    private String nomeFantasia;
    private String razaoSocial;
    @CNPJ
    @Column(unique = true)
    private String cnpj;
    private String telefone;
    @Email
    private String email;
    private String site;
    @NotNull
    private Boolean ativo;
    @ManyToOne
    private Endereco endereco;

    public Fornecedor(String nomeFantasia, String razaoSocial, String cnpj, String telefone, String email, String site, Boolean ativo) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
        this.ativo = ativo;
    }

    @Deprecated
    public Fornecedor() {
    }
}
