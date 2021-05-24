package br.com.terracota.sistematerracota.empresas;

import br.com.terracota.sistematerracota.enderecos.Endereco;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Boolean ativo = Boolean.TRUE;
    @ManyToOne
    private Endereco endereco;
    @Column(updatable = false)
    private final LocalDateTime dataCriacao = LocalDateTime.now();

    public Empresa(String nomeFantasia, String razaoSocial, String cnpj, String telefone, String email, String site) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
    }

    @Deprecated
    public Empresa() {
    }
}