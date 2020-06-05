package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ClienteEntradaDto;
import br.com.tt.petshop.dto.ClienteSaidaDto;
import br.com.tt.petshop.exception.CpfInvalidoException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import br.com.tt.petshop.util.CpfValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private CpfValidator cpfValidator;

    public ClienteService(ClienteRepository clienteRepository,
                          CpfValidator cpfValidator) {
        this.clienteRepository = clienteRepository;
        this.cpfValidator = cpfValidator;
    }

    public List<ClienteSaidaDto> listarClientes(){
/*
        List<Cliente> lista = this.clienteRepository.listarClientes();
        List<ClienteSaidaDto> listaRetornoMetodo = new ArrayList<>();
        for (Cliente cliente : lista){
            ClienteSaidaDto dto = ClienteSaidaDto.build(cliente);
            listaRetornoMetodo.add(dto);
        }
        return listaRetornoMetodo;
*/
        //Stream??
        return this.clienteRepository.listarClientes()
                .stream()
                .map(ClienteSaidaDto::converte)
                .collect(Collectors.toList());
    }

    @Transactional//Deixa tudo abaixo de uma transação, ou seja, propricia ROLLBACK!
    //Poderia estar no Repository também, mas é mais comum no Service.
    public Cliente criarCliente(ClienteEntradaDto clienteEntrada) {

        if( ! cpfValidator.verificaSeCpfValido(clienteEntrada.getCpf())){
            throw new CpfInvalidoException("O formato do CPF está incorreto!");
        }

        Cliente clienteEntidade = new Cliente(clienteEntrada);
        return clienteRepository.criarCliente(clienteEntidade);
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
