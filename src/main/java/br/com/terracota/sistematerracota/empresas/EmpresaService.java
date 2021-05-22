package br.com.terracota.sistematerracota.empresas;

import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private final EmpresaRepository lojaRepository;

    public EmpresaService(EmpresaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }


    public void converteESalva(EmpresaRequest lojaRequest) {

    }
}
