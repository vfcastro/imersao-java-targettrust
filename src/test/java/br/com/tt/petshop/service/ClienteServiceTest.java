package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ClienteEntradaDto;
import br.com.tt.petshop.exception.CpfInvalidoException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import br.com.tt.petshop.util.CpfValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    private ClienteRepository clientRepositoryMock;
    private CpfValidator cpfValidatorMock;

    private ClienteService clienteService;

    @BeforeEach
    void inicializacao(){
        clientRepositoryMock = Mockito.mock(ClienteRepository.class);
        cpfValidatorMock = Mockito.mock(CpfValidator.class);
        clienteService = new ClienteService(clientRepositoryMock, cpfValidatorMock);
    }

    @Test
    void deveriaListarUsandoORepository(){

        //Preparação
        ClienteEntradaDto dto = new ClienteEntradaDto("Gilberto", "911.948.160-88");
        Mockito.when(clientRepositoryMock.listarClientes()).thenReturn(List.of(new Cliente(dto)));

        //Act
        List<Cliente> clientes = clienteService.listarClientes();

        //Verificação
        assertNotNull(clientes);

        Cliente clienteGilberto = clientes.get(0);
        assertEquals("911.948.160-88", clienteGilberto.getCpf());
        assertEquals("Gilberto (911.948.160-88)", clienteGilberto.getDescricao());
        Mockito.verify(clientRepositoryMock).listarClientes();
    }

    @Test
    void deveriaSalvarComSucesso(){
        //Preparação
        ClienteEntradaDto clienteDtoASerSalvo = new ClienteEntradaDto("Fulano dos Santos", "CPF_VALIDO");
        Mockito.when(cpfValidatorMock.verificaSeCpfValido("CPF_VALIDO")).thenReturn(true);
        Cliente clienteASerSalvo = new Cliente(clienteDtoASerSalvo);

        //Act
        clienteService.criarCliente(clienteDtoASerSalvo);

        //Verificação = 1 chamada = Mockito.times(1)
        Mockito.verify(clientRepositoryMock).criarCliente(clienteASerSalvo);
    }

    @Test
    void deveriaFalharComCpfInvalido(){
        //Preparação
        ClienteEntradaDto clienteASerSalvo = new ClienteEntradaDto("Fulano dos Santos", "CPF_INVALIDO");
        Mockito.when(cpfValidatorMock.verificaSeCpfValido("CPF_INVALIDO")).thenReturn(false);

        //Act
        assertThrows(CpfInvalidoException.class,
                () -> clienteService.criarCliente(clienteASerSalvo));

        //Verificação
        //Mockito.verify(clientRepositoryMock, Mockito.times(0)).criarCliente(clienteASerSalvo);
        Mockito.verifyNoInteractions(clientRepositoryMock);
    }

}