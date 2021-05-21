package br.com.terracota.sistematerracota.clientes;

import br.com.terracota.sistematerracota.clientes.endereco.EnderecoRequest;
import br.com.terracota.sistematerracota.clientes.endereco.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final EnderecoService enderecoService;

    public ClienteController(ClienteService clienteService, EnderecoService enderecoService) {
        this.clienteService = clienteService;
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<String> novoCliente(@Valid @RequestBody ClienteRequest clienteRequest, EnderecoRequest enderecoRequest) {

        // Valida se já existe um Cliente cadastrado com o CPF, CNPJ ou Email.
        clienteService.validaDados(clienteRequest);

        //Converte o objeto para um Cliente e salva no banco.
        Cliente cliente = clienteService.converteESalva(clienteRequest);

        //Verifica se existe endereço na requisição, converte para um Endereço e salva no banco.
        enderecoService.converteESalva(enderecoRequest, cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado");
    }
}
