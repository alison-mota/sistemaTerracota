package br.com.terracota.sistematerracota.produtos;

import br.com.terracota.sistematerracota.empresas.Empresa;
import br.com.terracota.sistematerracota.empresas.EmpresaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final EmpresaRepository empresaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, EmpresaRepository empresaRepository) {
        this.produtoRepository = produtoRepository;
        this.empresaRepository = empresaRepository;
    }

    public void converteESalva(ProdutoRequest produtoRequest, Empresa empresa) {
        Produto produto = produtoRequest.toModel(empresa);
        produtoRepository.save(produto);
    }
}
