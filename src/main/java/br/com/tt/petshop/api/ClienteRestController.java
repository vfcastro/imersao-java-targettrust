package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.ClienteEntradaDto;
import br.com.tt.petshop.dto.ClienteSaidaDto;
import br.com.tt.petshop.dto.MensagemErroDto;
import br.com.tt.petshop.exception.CpfInvalidoException;
import br.com.tt.petshop.exception.ErroNegocioException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ClienteRestController {

    private final ClienteService clienteService;

    public ClienteRestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping(value = "/clientes", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity criar(@RequestBody ClienteEntradaDto dto){
        Cliente clienteCriado = clienteService.criarCliente(dto);
        String location = String.format("/clientes/%d", clienteCriado.getId());

        return ResponseEntity
                .created(URI.create(location))
                .build();
    }

    @GetMapping(value = "/clientes", produces = APPLICATION_JSON_VALUE)
    public List<ClienteSaidaDto> lista(){
        return clienteService.listarClientes();
    }

    @GetMapping(value = "/clientes/{clienteId}", produces = "application/json")
    public Cliente buscarPorId(@PathVariable("clienteId") Integer id){
        return clienteService.buscarPorId(id);
    }

    //Put /clientes/{id} -> body json (campos do objeto a ser atualizado!)
    @PutMapping("/clientes/{idCliente}")
    public ResponseEntity atualizar(@PathVariable("idCliente") Integer idCliente,
                                    @RequestBody ClienteEntradaDto clienteEntradaDto){
        clienteService.atualizar(idCliente, clienteEntradaDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity remover(@PathVariable("id") Integer id){
        clienteService.removerPorId(id);
        return ResponseEntity.noContent().build();
    }

/*    @ExceptionHandler(CpfInvalidoException.class)
    public ResponseEntity<MensagemErroDto>
                trataCpfInvalido(CpfInvalidoException e){
        return ResponseEntity
                .badRequest()
                .body("Cpf inválido!!");// ou e.getMessage()
    }*/

    /**
     * Forma mais simples de tratar uma exceção no Spring MVC!
     */
    @ExceptionHandler(CpfInvalidoException.class)
    public ResponseEntity<MensagemErroDto> trataCpfInvalido(CpfInvalidoException e) {
        MensagemErroDto mensagemErro = new MensagemErroDto("cpf_invalido", e.getMessage());
        return ResponseEntity.badRequest().body(mensagemErro);
    }
}
