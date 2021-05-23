package br.com.terracota.sistematerracota.clientes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<String> novoCliente(@Valid @RequestBody ClienteRequest clienteRequest) {

        // Valida se já existe um Cliente cadastrado com o CPF, CNPJ ou Email.
        clienteService.validaClienteUnico(clienteRequest);

        // Converte o objeto para um Cliente e salva no banco.
        clienteService.converteESalva(clienteRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado");
    }
}