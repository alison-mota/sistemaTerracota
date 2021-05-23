package br.com.terracota.sistematerracota.empresas;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class EmpresaRequest {

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
    private Boolean ativo;

    public Empresa toModel() {
        return new Empresa(nomeFantasia, razaoSocial, cnpj, telefone, email, site);
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSite() {
        return site;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
