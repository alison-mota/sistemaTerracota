package br.com.terracota.sistematerracota.fornecedores;

import br.com.terracota.sistematerracota.empresas.Empresa;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public void validaFornecedorUnico(FornecedorRequest fornecedorRequest) {
        if(fornecedorRepository.existsByCnpj(fornecedorRequest.getCnpj())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um fornecedor com esse CNPJ");
        }
    }

    public void converteESalva(FornecedorRequest fornecedorRequest, Empresa empresa) {
        Fornecedor fornecedor = fornecedorRequest.toModel(empresa);
        fornecedorRepository.save(fornecedor);
    }
}
