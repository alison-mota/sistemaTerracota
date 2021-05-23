package br.com.terracota.sistematerracota.empresas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/loja")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService lojaService) {
        this.empresaService = lojaService;
    }

    @PostMapping
    public ResponseEntity<String> novaLoja(@Valid @RequestBody EmpresaRequest lojaRequest) {

        empresaService.converteESalva(lojaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Empresa cadastrada.");
    }
}
