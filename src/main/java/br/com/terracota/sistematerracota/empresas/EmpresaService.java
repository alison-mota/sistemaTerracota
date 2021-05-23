package br.com.terracota.sistematerracota.empresas;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository lojaRepository) {
        this.empresaRepository = lojaRepository;
    }

    public void converteESalva(EmpresaRequest empresaRequest) {
        Empresa empresa = empresaRequest.toModel();
        empresaRepository.save(empresa);

    }

    public void validaEmpresaUnica(EmpresaRequest empresaRequest) {
        if(empresaRepository.existsByCnpj(empresaRequest.getCnpj())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma empresa cadastrada com esse CNPJ");
        }
    }

    public Empresa validaEmpresa(Long empresaId) {
        return empresaRepository.findById(empresaId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada."));
    }
}
