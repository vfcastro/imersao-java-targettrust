package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    private UnidadeRepository unidadeRepository;

    //Services/Controllers/Repositories - NUNCA tem atributo específico de algum sessão/usuário
    //private String nomeUsuario;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    public List<UnidadeDto> listarUnidades() {
        return unidadeRepository.listarUnidades();
    }

    public void criarUnidade(UnidadeDto unidadeDto){
        unidadeRepository.criarUnidade(unidadeDto);
    }

    public UnidadeDto buscarPorId(Long idUnidade) {
        return unidadeRepository.buscarPorId(idUnidade);
    }

    public void atualizar(Long id, UnidadeDto unidadeDeEntrada) {
        UnidadeDto unidadeSalva = this.buscarPorId(id);
        unidadeSalva.atualizarInformacoes(unidadeDeEntrada);
        unidadeRepository.salvar(unidadeSalva);
    }
}
