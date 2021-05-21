package br.com.terracota.sistematerracota.cliente.endereco;

import br.com.terracota.sistematerracota.cliente.Cliente;
import br.com.terracota.sistematerracota.cliente.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/cliente/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;
    private final ClienteService clienteService;

    public EnderecoController(EnderecoService enderecoService, ClienteService clienteService) {
        this.enderecoService = enderecoService;
        this.clienteService = clienteService;
    }

    @PostMapping("/{clienteId}")
    public ResponseEntity<String> novoEndereco(@Valid @RequestBody EnderecoRequest enderecoRequest, @PathVariable Long clienteId) {

        // Localiza e devolve o cliente ou exceção.
        Cliente cliente = clienteService.localizaCliente(clienteId);

        // Converte para um Endereço e salva no banco.
        enderecoService.converteESalva(enderecoRequest, cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Endereço salvo");
    }
}
