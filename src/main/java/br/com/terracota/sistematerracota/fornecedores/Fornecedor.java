package br.com.terracota.sistematerracota.fornecedores;

import br.com.terracota.sistematerracota.empresas.Empresa;
import br.com.terracota.sistematerracota.enderecos.Endereco;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

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
    private Boolean ativo = Boolean.TRUE;
    @ManyToOne
    private Endereco endereco;
    @Column(updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @ManyToOne
    private Empresa empresa;

    public Fornecedor(String nomeFantasia, String razaoSocial, String cnpj, String telefone, String email, String site, Empresa empresa) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
        this.empresa = empresa;
    }

    @Deprecated
    public Fornecedor() {
    }
}
