package br.com.terracota.sistematerracota.fornecedores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/fornecedor")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    public ResponseEntity<String> novoFornecedor(@Valid @RequestBody FornecedorRequest fornecedorRequest){

        // Valida se existe um fornecedor com o mesmo CNPJ, encerrando o código com Exception.
        fornecedorService.validaFornecedorUnico(fornecedorRequest);

        // Converte para um objeto Fornecedor e salva no banco.
        fornecedorService.converteESalva(fornecedorRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("Fornecedor cadastrado");
    }
}
