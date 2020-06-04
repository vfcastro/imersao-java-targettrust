package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ClienteEntradaDto;
import br.com.tt.petshop.exception.CpfInvalidoException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import br.com.tt.petshop.util.CpfValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private CpfValidator cpfValidator;

    public ClienteService(ClienteRepository clienteRepository,
                          CpfValidator cpfValidator) {
        this.clienteRepository = clienteRepository;
        this.cpfValidator = cpfValidator;
    }

    public List<Cliente> listarClientes(){
        return this.clienteRepository.listarClientes();
    }

    @Transactional//Deixa tudo abaixo de uma transação, ou seja, propricia ROLLBACK!
    //Poderia estar no Repository também, mas é mais comum no Service.
    public void criarCliente(ClienteEntradaDto clienteEntrada) {

        if( ! cpfValidator.verificaSeCpfValido(clienteEntrada.getCpf())){
            throw new CpfInvalidoException();
        }

        Cliente cliente = new Cliente(clienteEntrada);
        clienteRepository.criarCliente(cliente);
    }

    public Cliente buscarPorId(Integer id) {
        return clienteRepository.buscarPorId(id);
    }

    @Transactional
    public Cliente atualizar(Integer idCliente, ClienteEntradaDto clienteEntradaDto){
        Cliente clienteDaBase = clienteRepository.buscarPorId(idCliente);
        clienteDaBase.atualizarDadosCliente(clienteEntradaDto);
        return clienteRepository.atualizar(clienteDaBase);
    }

    @Transactional
    public void remover(Integer id){
        Cliente clienteASerRemovido = this.buscarPorId(id);
        if(clienteASerRemovido != null){
            clienteRepository.remover(clienteASerRemovido);
        }
    }

    @Transactional
    public void removerPorId(Integer id){
        clienteRepository.removerPorId(id);
    }
}
