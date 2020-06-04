package br.com.tt.petshop.servicecommock;

import br.com.tt.petshop.dto.ClienteEntradaDto;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;

import java.util.Arrays;
import java.util.List;

public class MockGilbertoClienteRepository extends ClienteRepository {

    public MockGilbertoClienteRepository() {
        super(null);
    }

    @Override
    public List<Cliente> listarClientes() {
        Cliente gilberto = new Cliente(new ClienteEntradaDto("Gilberto", "911.948.160-88"));
        return Arrays.asList(gilberto);
    }

    int chamouSalvar = 0;

    @Override
    public Cliente criarCliente(Cliente cliente) {
        chamouSalvar++;
        return cliente;
    }

    public int getChamouSalvar() {
        return chamouSalvar;
    }
}
