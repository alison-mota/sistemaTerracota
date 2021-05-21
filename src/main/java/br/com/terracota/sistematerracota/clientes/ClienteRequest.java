package br.com.terracota.sistematerracota.clientes;

import br.com.terracota.sistematerracota.anotacoes.CPFOuCNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClienteRequest {

    @NotBlank
    private String nome;
    @CPFOuCNPJ
    private String documento;
    private String telefone;
    @Email
    private String email;

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

    public Cliente toModel() {
        return new Cliente(nome, documento, telefone, email);
    }
}
