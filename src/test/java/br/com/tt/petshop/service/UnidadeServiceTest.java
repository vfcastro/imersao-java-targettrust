package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.repository.UnidadeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UnidadeServiceTest {

    private UnidadeRepository unidadeRepositoryMock;
    private UnidadeService unidadeService;

    @BeforeEach
    void inicializa(){
        unidadeRepositoryMock = mock(UnidadeRepository.class);
        unidadeService = new UnidadeService(unidadeRepositoryMock);
    }

    @Test
    void deveriaCriarComSucesso(){
        UnidadeDto unidade = new UnidadeDto(100, "ZS", "Rua Mario Totta, 32");

        unidadeService.criarUnidade(unidade);

        verify(unidadeRepositoryMock).criarUnidade(unidade);
    }

    @Test
    void deveriaListarUnidades(){
        //Preparação
        List<UnidadeDto> listaUnidades = List.of(
                new UnidadeDto(1, "Zona Sul", "Av. Cavalhada, 1050"));

        when(unidadeRepositoryMock.listarUnidades()).thenReturn(listaUnidades);

        //Ação
        List<UnidadeDto> retorno = unidadeService.listarUnidades();

        //Verificação
        assertEquals(1, retorno.size());
        UnidadeDto primeiraUnidade = retorno.stream().findFirst().orElseThrow();// .get(0)
        assertEquals("Zona Sul", primeiraUnidade.getNome());
        assertEquals("Av. Cavalhada, 1050", primeiraUnidade.getEndereco());
        assertEquals("Zona Sul - Av. Cavalhada, 1050", primeiraUnidade.getDescricao());

        verify(unidadeRepositoryMock).listarUnidades();
    }


}