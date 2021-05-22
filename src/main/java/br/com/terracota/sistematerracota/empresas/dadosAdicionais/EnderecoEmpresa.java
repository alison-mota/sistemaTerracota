package br.com.terracota.sistematerracota.empresas.dadosAdicionais;

import javax.persistence.Embeddable;

@Embeddable
public class EnderecoEmpresa {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String complemento;

    public EnderecoEmpresa(String rua, String numero, String bairro, String cidade, String cep, String complemento) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.complemento = complemento;
    }

    @Deprecated
    public EnderecoEmpresa() {
    }
}
