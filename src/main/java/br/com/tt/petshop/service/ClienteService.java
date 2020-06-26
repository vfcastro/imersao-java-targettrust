package br.com.tt.petshop.service;

import br.com.tt.petshop.client.CreditoDto;
import br.com.tt.petshop.client.CreditoFeignClient;
import br.com.tt.petshop.client.CreditoRestTemplateClient;
import br.com.tt.petshop.dto.ClienteEntradaDto;
import br.com.tt.petshop.dto.ClienteSaidaDto;
import br.com.tt.petshop.exception.CpfInvalidoException;
import br.com.tt.petshop.exception.ErroNegocioException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import br.com.tt.petshop.util.CpfValidator;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Validated//Necessário somente para usar o valid no Service
public class ClienteService {

    private static final String SEPARADOR = " ";

    private final ClienteRepository clienteRepository;
    private final CpfValidator cpfValidator;
    private final CreditoFeignClient creditoClient;

    public ClienteService(ClienteRepository clienteRepository,
                          CpfValidator cpfValidator, CreditoFeignClient creditoClient) {
        this.clienteRepository = clienteRepository;
        this.cpfValidator = cpfValidator;
        this.creditoClient = creditoClient;
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
    public Cliente criarCliente(@Valid ClienteEntradaDto clienteEntrada) {

        verificaSeCPfEhValido(clienteEntrada);

        if(!verificaSeNomePossuiQuantidadePartes(clienteEntrada.getNome())){
            throw new ErroNegocioException("nome_invalido", "Informe seu nome completo!");
        }

        if(!verificaSePartesDoNomePossuemTamanhoMinimo(clienteEntrada.getNome())){
            throw new ErroNegocioException("nome_invalido", "Informe seu nome sem abreviações!");
        }

        if(possuiPendencia(clienteEntrada.getCpf())){
            throw new ErroNegocioException("problema_credito",
                    "Há um problema com o cadastro no sistema de crédito. Verificar situação do CPF");
        }

        Cliente clienteEntidade = new Cliente(clienteEntrada);
        return clienteRepository.criarCliente(clienteEntidade);
    }

    private boolean possuiPendencia(String cpf) {
        CreditoDto creditoDto = creditoClient.consultaSituacaoCpf(cpf);
        return creditoDto.isNegativado();
    }

    /*
     * Cada parte do nome da pessoa deve conter ao menos 2 letras.
     */
    private boolean verificaSePartesDoNomePossuemTamanhoMinimo(String nome) {
//        String[] partes = nome.split(SEPARADOR);
//        for(String parte : partes){
//            if(parte.length() < 2){
//                return false;
//            }
//        }
//        return true;

        return Stream.of(nome.split(SEPARADOR))
                .allMatch(parte -> parte.length() >= 2);
    }

    /*
     * O nome da pessoa deve ser composta de pelo menos duas partes.
     */
    private boolean verificaSeNomePossuiQuantidadePartes(String nome) {
        return nome.split(SEPARADOR).length >= 2;
    }

    public Cliente buscarPorId(Integer id) {
        return clienteRepository.buscarPorId(id);
    }

    @Transactional
    public Cliente atualizar(@NotNull @Positive Integer idCliente, @Valid @NotNull ClienteEntradaDto clienteEntradaDto){

        verificaSeCPfEhValido(clienteEntradaDto);

        Cliente clienteDaBase = clienteRepository.buscarPorId(idCliente);
        clienteDaBase.atualizarDadosCliente(clienteEntradaDto);
        return clienteRepository.atualizar(clienteDaBase);
    }

    private void verificaSeCPfEhValido(ClienteEntradaDto clienteEntradaDto) {
        if (!cpfValidator.verificaSeCpfValido(clienteEntradaDto.getCpf())) {
            throw new CpfInvalidoException("O formato do CPF está incorreto!");
        }
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
