package br.com.tt.petshop.service;

import br.com.tt.petshop.model.projection.RelatorioAnimalProjection;
import br.com.tt.petshop.repository.relatorio.RelatorioAnimalRepository;
import br.com.tt.petshop.repository.relatorio.RelatorioClienteRepository;
import br.com.tt.petshop.model.projection.RelatorioClienteProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    private final RelatorioClienteRepository relatorioClienteRepository;
    private final RelatorioAnimalRepository relatorioAnimalRepository;

    public RelatorioService(RelatorioClienteRepository relatorioClienteRepository, RelatorioAnimalRepository relatorioAnimalRepository) {
        this.relatorioClienteRepository = relatorioClienteRepository;
        this.relatorioAnimalRepository = relatorioAnimalRepository;
    }

    public List<RelatorioClienteProjection> listarClientes(){
        return relatorioClienteRepository.listarClientes();
    }

    public List<RelatorioAnimalProjection> listarAnimais(){
        return relatorioAnimalRepository.listarAnimais();
    }

}
