package br.com.terracota.sistematerracota.enderecos;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @Column(updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Endereco(String rua, String numero, String bairro, String cidade, String cep, String complemento) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.complemento = complemento;
    }

    @Deprecated
    public Endereco() {
    }
}
