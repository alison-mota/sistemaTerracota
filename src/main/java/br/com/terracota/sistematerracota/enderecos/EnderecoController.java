package br.com.terracota.sistematerracota.enderecos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<String> novoEndereco(@Valid @RequestBody EnderecoRequest enderecoRequest) {

        // Converte para um Endereço e salva no banco.
        enderecoService.converteESalva(enderecoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Endereço salvo");
    }
}
