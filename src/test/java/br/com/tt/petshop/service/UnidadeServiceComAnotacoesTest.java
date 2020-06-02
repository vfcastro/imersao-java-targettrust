package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.repository.UnidadeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Esse ExtendWith garante que o JUnit entenda as anotações do Mockito!
 */
@ExtendWith(MockitoExtension.class)
class UnidadeServiceComAnotacoesTest {

    @Mock // isso substitui o unidadeRepositoryMock = mock(UnidadeRepository.class);
    private UnidadeRepository unidadeRepositoryMock;

    // Em vez de dar New no construtor podem usar @InjectMocks
    private UnidadeService unidadeService;

    @BeforeEach
    void inicializa(){
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