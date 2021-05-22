package br.com.terracota.sistematerracota.clientes.endereco;

import br.com.terracota.sistematerracota.clientes.Cliente;

import javax.validation.constraints.NotNull;

public class EnderecoRequest {

    final private String rua;
    final private String numero;
    final private String bairro;
    final private String cidade;
    final private String cep;
    final private String complemento;
    @NotNull
    private Boolean enderecoPrincipal;

    public EnderecoRequest(String rua, String numero, String bairro, String cidade, String cep, String complemento, Boolean enderecoPrincipal) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.complemento = complemento;
        this.enderecoPrincipal = enderecoPrincipal;
    }

    public Endereco toModel(Cliente cliente) {
        return new Endereco(rua, numero, bairro, cidade, cep, complemento, enderecoPrincipal, cliente);
    }
}
