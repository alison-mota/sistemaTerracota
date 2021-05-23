package br.com.terracota.sistematerracota.enderecos;

public class EnderecoRequest {

    final private String rua;
    final private String numero;
    final private String bairro;
    final private String cidade;
    final private String cep;
    final private String complemento;

    public EnderecoRequest(String rua, String numero, String bairro, String cidade, String cep, String complemento) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.complemento = complemento;
    }

    public Endereco toModel() {
        return new Endereco(rua, numero, bairro, cidade, cep, complemento);
    }
}
