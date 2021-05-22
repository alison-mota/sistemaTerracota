package br.com.terracota.sistematerracota.produtos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/produto")
public class ProdutoController {

    @PostMapping("/{lojaId}")
    public void novoProduto(@Valid @RequestBody ProdutoRequest produtoRequest, @PathVariable Long lojaId){

    }
}
