package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AnimalEntradaDto;
import br.com.tt.petshop.dto.AnimalSaidaDto;
import br.com.tt.petshop.enumeration.TipoAnimal;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/clientes/{idCliente}/animais")
public class AnimalRestController {

    private final AnimalService animalService;

    public AnimalRestController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity criar(@RequestBody @Valid AnimalEntradaDto dto,
                                @PathVariable("idCliente") Integer idCliente){

        Animal animalPersistido =  animalService.criarAnimal(dto, idCliente);

        String location = String.format("/clientes/%d/animais/%d", idCliente, animalPersistido.getId());
        return ResponseEntity.created(URI.create(location)).build();
    }

    /**
     * Listar Todos:
     *
     * /clientes/{idCliente}/animais
     *
     * - Requisito extra: Filtrar por tipo de animal
     *
     * /clientes/{idCliente}/animais?tipo=REPTIL
     * /clientes/{idCliente}/animais?tipo=MAMIFERO
     *
     * Dicas:
     * - Vai ser apenas um recurso no controller (com param não obrigatório)
     * - Provavelmente precisará de mais de 1 método no repository....
     */

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AnimalSaidaDto>> listar(@PathVariable("idCliente") Integer idCliente,
                                           @RequestParam(value = "tipo", required = false) TipoAnimal tipo){
                                           //@RequestParam("tipo") Optional<TipoAnimal> tipo

        //return animalService.listar(tipo, idCliente);
        return ResponseEntity.ok(animalService.listar(tipo, idCliente));
    }

}
