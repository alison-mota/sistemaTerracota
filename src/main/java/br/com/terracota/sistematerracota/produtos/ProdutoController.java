package br.com.terracota.sistematerracota.produtos;

import br.com.terracota.sistematerracota.empresas.Empresa;
import br.com.terracota.sistematerracota.empresas.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/produto")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final EmpresaService empresaService;

    public ProdutoController(ProdutoService produtoService, EmpresaService empresaService) {
        this.produtoService = produtoService;
        this.empresaService = empresaService;
    }

    @PostMapping("/{empresaId}")
    public ResponseEntity<String> novoProduto(@Valid @RequestBody ProdutoRequest produtoRequest, @PathVariable Long empresaId) {

        // Valida se existe a empresa e retorna um objeto Empresa.
        Empresa empresa = empresaService.validaEmpresa(empresaId);

        // Converte para um objeto tipo produto e salva no banco.
        produtoService.converteESalva(produtoRequest, empresa);

        return ResponseEntity.status(HttpStatus.CREATED).body("Produto cadastrado");
    }
}
