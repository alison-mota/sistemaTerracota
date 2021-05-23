package br.com.terracota.sistematerracota.fornecedores;

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

    public void converteESalva(FornecedorRequest fornecedorRequest) {
        Fornecedor fornecedor = fornecedorRequest.toModel();
        fornecedorRepository.save(fornecedor);
    }
}
