package br.com.terracota.sistematerracota.clientes;

import br.com.terracota.sistematerracota.compartilhado.anotacoes.CPFOuCNPJ;

import javax.validation.constraints.Email;

public class ClienteRequestAtualizar {

    private String nome;
    @CPFOuCNPJ
    private String documento;
    private String telefone;
    @Email
    private String email;
    private String origemCliente;
    private Boolean ativo;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrigemCliente(String origemCliente) {
        this.origemCliente = origemCliente;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

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

    public Boolean getAtivo() {
        return ativo;
    }
}
