package br.com.terracota.sistematerracota.clientes.endereco;

import br.com.terracota.sistematerracota.clientes.Cliente;

public class EnderecoRequest {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String complemento;


    public Endereco toModel(Cliente cliente) {
        return new Endereco(rua, numero, bairro, cidade, cep, complemento, cliente);
    }
}
