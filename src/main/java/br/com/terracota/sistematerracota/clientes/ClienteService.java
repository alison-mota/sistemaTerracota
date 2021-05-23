package br.com.terracota.sistematerracota.clientes;

import br.com.terracota.sistematerracota.enderecos.Endereco;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void validaClienteUnico(ClienteRequest request) {
        if (clienteRepository.existsByEmail(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um cliente cadastrado com esse E-mail.");
        } else if (clienteRepository.existsByDocumento(request.getDocumento())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um cliente cadastrado com esse CPF ou CNPJ.");
        }
    }

    public void converteESalva(ClienteRequest request) {
        Cliente cliente = request.toModel();
        clienteRepository.save(cliente);
    }

}
