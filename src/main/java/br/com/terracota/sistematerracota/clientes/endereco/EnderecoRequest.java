package br.com.terracota.sistematerracota.clientes.endereco;

import br.com.terracota.sistematerracota.clientes.Cliente;

import javax.validation.constraints.NotBlank;

public class EnderecoRequest {

    @NotBlank
    private String rua;
    @NotBlank
    private String numero;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String cep;
    private String complemento;

    public Endereco toModel(Cliente cliente) {
        return new Endereco(rua, numero, bairro, cidade, cep, complemento, cliente);
    }
}
