package br.com.terracota.sistematerracota.clientes;

import br.com.terracota.sistematerracota.empresas.Empresa;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void validaClienteUnico(ClienteRequestNovo request, Long empresa) {
        if (clienteRepository.existsByEmail(request.getEmail()) && clienteRepository.existsByEmpresaId(empresa)) {
            System.out.println(empresa);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um cliente cadastrado com esse E-mail.");
        } else if (clienteRepository.existsByDocumento(request.getDocumento()) && clienteRepository.existsByEmpresaId(empresa)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um cliente cadastrado com esse CPF ou CNPJ.");
        }
    }

    public void converteESalva(ClienteRequestNovo request, Empresa empresa) {
        Cliente cliente = request.toModel(empresa);
        clienteRepository.save(cliente);
    }

    public Cliente atualizaCliente(ClienteRequestAtualizar clienteRequest, Long clienteId) {
        Cliente clienteAtual = clienteRepository.getById(clienteId);
        clienteAtual.setNome(clienteRequest.getNome());
        clienteAtual.setDocumento(clienteRequest.getDocumento());
        clienteAtual.setTelefone(clienteRequest.getTelefone());
        clienteAtual.setEmail(clienteRequest.getEmail());
        clienteAtual.setOrigemCliente(clienteRequest.getOrigemCliente());
        clienteAtual.setAtivo(clienteRequest.getAtivo());

        return clienteAtual;

    }
}
