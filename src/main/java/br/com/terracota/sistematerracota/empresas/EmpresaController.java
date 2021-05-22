package br.com.terracota.sistematerracota.empresas;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/loja")
public class EmpresaController {

    private final EmpresaService lojaService;

    public EmpresaController(EmpresaService lojaService) {
        this.lojaService = lojaService;
    }

    @PostMapping
    public void novaLoja(@Valid @RequestBody EmpresaRequest lojaRequest) {

        lojaService.converteESalva(lojaRequest);

    }
}
