package br.com.terracota.sistematerracota.cliente.endereco;

import br.com.terracota.sistematerracota.cliente.Cliente;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public void converteESalva(EnderecoRequest enderecoRequest, Cliente cliente) {
        Endereco endereco = enderecoRequest.toModel(cliente);
        enderecoRepository.save(endereco);

    }
}