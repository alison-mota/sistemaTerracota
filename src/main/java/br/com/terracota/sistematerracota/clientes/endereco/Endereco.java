package br.com.terracota.sistematerracota.clientes.endereco;

import br.com.terracota.sistematerracota.clientes.Cliente;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String complemento;
    @ManyToOne
    private Cliente cliente;
    @NotNull
    private Boolean enderecoPrincipal;

    public Endereco(String rua, String numero, String bairro, String cidade, String cep, String complemento, Boolean enderecoPrincipal, Cliente cliente) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.complemento = complemento;
        this.enderecoPrincipal = enderecoPrincipal;
        this.cliente = cliente;
    }

    @Deprecated
    public Endereco() {
    }
}
