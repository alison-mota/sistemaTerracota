package br.com.terracota.sistematerracota.empresas;

import org.springframework.stereotype.Service;

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
}
