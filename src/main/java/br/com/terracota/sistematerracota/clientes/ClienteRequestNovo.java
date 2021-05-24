package br.com.terracota.sistematerracota.clientes;

import br.com.terracota.sistematerracota.compartilhado.anotacoes.CPFOuCNPJ;
import br.com.terracota.sistematerracota.empresas.Empresa;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClienteRequestNovo {

    @NotBlank
    private String nome;
    @CPFOuCNPJ
    private String documento;
    private String telefone;
    @Email
    private String email;
    private String origemCliente;
    private Boolean ativo;

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getOrigemCliente() {
        return origemCliente;
    }

    public Cliente toModel(Empresa empresa) {
        return new Cliente(nome, telefone, email, documento, origemCliente, empresa);
    }
}
