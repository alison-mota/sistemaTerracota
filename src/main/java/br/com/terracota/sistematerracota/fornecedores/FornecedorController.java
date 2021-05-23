package br.com.terracota.sistematerracota.fornecedores;

import br.com.terracota.sistematerracota.empresas.Empresa;
import br.com.terracota.sistematerracota.empresas.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/fornecedor")
public class FornecedorController {

    private final FornecedorService fornecedorService;
    private final EmpresaService empresaService;

    public FornecedorController(FornecedorService fornecedorService, EmpresaService empresaService) {
        this.fornecedorService = fornecedorService;
        this.empresaService = empresaService;
    }

    @PostMapping("/{empresaId}")
    public ResponseEntity<String> novoFornecedor(@Valid @RequestBody FornecedorRequest fornecedorRequest, @PathVariable Long empresaId){

        // Valida e retorna e empresa ou exception se não encontrar
        Empresa empresa = empresaService.validaEmpresa(empresaId);

        // Valida se existe um fornecedor com o mesmo CNPJ, encerrando o código com Exception.
        fornecedorService.validaFornecedorUnico(fornecedorRequest, empresaId);

        // Converte para um objeto Fornecedor e salva no banco.
        fornecedorService.converteESalva(fornecedorRequest, empresa);

        return ResponseEntity.status(HttpStatus.CREATED).body("Fornecedor cadastrado");
    }
}
