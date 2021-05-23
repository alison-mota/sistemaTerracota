package br.com.terracota.sistematerracota.empresas;

import br.com.terracota.sistematerracota.enderecos.Endereco;
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
    @ManyToOne
    private Endereco endereco;

    public Empresa(String nomeFantasia, String razaoSocial, String cnpj, String telefone, String email, String site, Boolean ativo) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
        this.ativo = ativo;
    }

    @Deprecated
    public Empresa() {
    }
}
