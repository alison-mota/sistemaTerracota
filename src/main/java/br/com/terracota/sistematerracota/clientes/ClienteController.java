package br.com.terracota.sistematerracota.clientes;

import br.com.terracota.sistematerracota.empresas.Empresa;
import br.com.terracota.sistematerracota.empresas.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final EmpresaService empresaService;

    public ClienteController(ClienteService clienteService, EmpresaService empresaService) {
        this.clienteService = clienteService;
        this.empresaService = empresaService;
    }

    @PostMapping("/{empresaId}")
    public ResponseEntity<String> novoCliente(@Valid @RequestBody ClienteRequest clienteRequest, @PathVariable Long empresaId) {

        // Localiza e retorna um objeto tipo empresa ou uma exception
        Empresa empresa = empresaService.validaEmpresa(empresaId);

        // Valida se já existe um Cliente cadastrado nesta em presa com o CPF, CNPJ ou Email.
        clienteService.validaClienteUnico(clienteRequest, empresa);

        // Converte o objeto para um Cliente e salva no banco.
        clienteService.converteESalva(clienteRequest, empresa);

        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado");
    }
}