package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.UnidadeEntradaDto;
import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public int criarUnidade(UnidadeEntradaDto unidadeDto){
        return unidadeRepository.criarUnidade(unidadeDto);
    }

    public UnidadeDto buscarPorId(Long idUnidade) {
        return unidadeRepository.buscarPorId(idUnidade);
    }

    public void atualizar(Long id, UnidadeEntradaDto unidadeDeEntrada) {
        UnidadeDto unidade = this.buscarPorId(id);
        unidade.atualizarInformacoes(unidadeDeEntrada);
        unidadeRepository.salvar(unidade);
    }

    @Transactional
    public void remover(Long id) {
        unidadeRepository.remover(id);
    }
}
