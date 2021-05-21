package br.com.terracota.sistematerracota.clientes;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void validaDados(ClienteRequest request) {
        if (clienteRepository.existByEmail(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um cliente cadastrado com esse E-mail.");
        } else if (clienteRepository.existByDocumento(request.getDocumento())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um cliente cadastrado com esse CPF ou CNPJ.");
        }
    }

    public Cliente converteESalva(ClienteRequest request) {
        Cliente cliente = request.toModel();
        clienteRepository.save(cliente);
        return cliente;
    }
}