package br.com.terracota.sistematerracota.clientes;

import br.com.terracota.sistematerracota.compartilhado.anotacoes.CPFOuCNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @NotBlank
    private String nome;
    @CPFOuCNPJ
    private String documento;
    private String telefone;
    @Email
    private String email;
    private String origemCliente;
    @NotNull
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

    public Cliente toModel() {
        return new Cliente(nome, telefone, email, documento, origemCliente, ativo);
    }
}
