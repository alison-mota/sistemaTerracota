package br.com.terracota.sistematerracota.cliente;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;
    private String nome;
    private String telefone;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String documento;

    public Cliente(String nome, String telefone, String email, String documento) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.documento = documento;
    }

    @Deprecated
    public Cliente() {
    }
}
