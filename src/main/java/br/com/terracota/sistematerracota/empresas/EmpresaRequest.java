package br.com.terracota.sistematerracota.empresas;

import br.com.terracota.sistematerracota.empresas.dadosAdicionais.EnderecoEmpresa;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class EmpresaRequest {

    @NotBlank
    private String nomeFantasia;
    private String razaoSocial;
    @CNPJ
    private String cnpj;
    private String telefone;
    @Email
    private String email;
    private String site;
    private Boolean ativo;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String complemento;

    public Empresa toModel() {
        EnderecoEmpresa enderecoEmpresa = new EnderecoEmpresa(rua, numero, bairro, cidade, cep, complemento);
        return new Empresa(nomeFantasia, razaoSocial, cnpj, telefone, email, site, ativo, enderecoEmpresa);
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

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }
}
