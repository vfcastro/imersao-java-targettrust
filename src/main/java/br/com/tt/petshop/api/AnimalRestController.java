package br.com.tt.petshop.api;


import br.com.tt.petshop.dto.AnimalEntradaDto;
import br.com.tt.petshop.dto.AnimalSaidaDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.service.AnimalService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public ResponseEntity criar(@RequestBody AnimalEntradaDto dto,
                                @PathVariable("idCliente") Integer idCliente){

        Animal animalPersistido =  animalService.criarAnimal(dto, idCliente);

        String location = String.format("/clientes/%d/animais/%d", idCliente, animalPersistido.getId());
        return ResponseEntity.created(URI.create(location)).build();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<AnimalSaidaDto> listar(@PathVariable Integer idCliente){
        return animalService.buscarAnimaisPorIdCliente(idCliente);
    }
}
