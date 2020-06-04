package br.com.tt.petshop.servicecommock;

import br.com.tt.petshop.dto.ClienteEntradaDto;
import br.com.tt.petshop.exception.CpfInvalidoException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import br.com.tt.petshop.service.ClienteService;
import br.com.tt.petshop.util.CpfValidator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    @Test
    void deveriaListarUsandoORepository(){

        //Preparação
        ClienteRepository clientRepositoryMock = new MockGilbertoClienteRepository();
        CpfValidator cpfValidator = new CpfValidator();

        //Act
        List<Cliente> clientes = new ClienteService(clientRepositoryMock, cpfValidator).listarClientes();

        //Verificação
        assertNotNull(clientes);
        assertEquals("911.948.160-88", clientes.get(0).getCpf());
    }

    @Test
    void deveriaSalvarComSucesso(){
        //Preparação
        ClienteEntradaDto clienteASerSalvo = new ClienteEntradaDto("Fulano dos Santos", "911.948.160-88");
        ClienteRepository clientRepositoryMock = new MockGilbertoClienteRepository();
        CpfValidator cpfValidator = new CpfValidator();

        //Act
        new ClienteService(clientRepositoryMock, cpfValidator).criarCliente(clienteASerSalvo);

        //Verificação
        assertEquals(1, ((MockGilbertoClienteRepository) clientRepositoryMock)
                .getChamouSalvar());
        //??? funcionou
    }

    @Test
    void deveriaFalharComCpfInvalido(){
        //Preparação
        ClienteEntradaDto clienteASerSalvo = new ClienteEntradaDto("Fulano dos Santos", "A11.948.160-88");
        ClienteRepository clientRepositoryMock = new MockGilbertoClienteRepository();
        CpfValidator cpfValidator = new CpfValidator();

        //Act
        assertThrows(CpfInvalidoException.class,
                () -> new ClienteService(clientRepositoryMock, cpfValidator).criarCliente(clienteASerSalvo));

        //Verificação
        assertEquals(0, ((MockGilbertoClienteRepository) clientRepositoryMock)
                .getChamouSalvar());
    }

}