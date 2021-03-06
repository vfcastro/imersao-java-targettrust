package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.UnidadeEntradaDto;
import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.service.UnidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController //@Controller + @ResponseBody
@RequestMapping("/unidades")
@Api(tags = {"unidade"})
public class UnidadeRestController {

    //final impede que esse atributo seja reinstaciado!
    private final UnidadeService unidadeService;

    public UnidadeRestController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criar(@RequestBody @Valid UnidadeEntradaDto dto){

        int idCriado = unidadeService.criarUnidade(dto);

        return ResponseEntity
                .created(URI.create(String.format("/unidades/%d", idCriado)))
                .build();
    }

    //@RequestMapping(method = RequestMethod.GET, value = "/unidades", produces = "application/json")
    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Lista de Unidades", notes = "Todas as unidades")
    public List<UnidadeDto> lista(){
        return unidadeService.listarUnidades();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UnidadeDto buscaPorId(@PathVariable("id") Long idUnidade){
        return unidadeService.buscarPorId(idUnidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarTodo(@PathVariable("id") Long id,
                                    @RequestBody @Valid UnidadeEntradaDto unidadeASerAtualizada){
        unidadeService.atualizar(id, unidadeASerAtualizada);

        return ResponseEntity.noContent().build();
    }

    //Remover  - DELETE /unidades/{identificador} -> NoContent (204)

    @DeleteMapping("/{id}")
    public ResponseEntity remover(
            @ApiParam(name = "id", value = "ID sequencial gerado na criacao")
            @PathVariable("id") Long id){
        unidadeService.remover(id); //Ação de remover??
        return ResponseEntity.noContent().build();
    }

}
