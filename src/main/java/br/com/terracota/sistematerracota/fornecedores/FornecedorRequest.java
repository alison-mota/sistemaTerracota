package br.com.terracota.sistematerracota.fornecedores;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FornecedorRequest {

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

    public Fornecedor toModel() {
        return new Fornecedor(nomeFantasia, razaoSocial, cnpj, telefone, email, site, ativo);
    }
}