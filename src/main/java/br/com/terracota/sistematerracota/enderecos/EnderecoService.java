package br.com.terracota.sistematerracota.enderecos;

import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public void converteESalva(EnderecoRequest enderecoRequest) {
        Endereco endereco = enderecoRequest.toModel();
        enderecoRepository.save(endereco);

    }
}