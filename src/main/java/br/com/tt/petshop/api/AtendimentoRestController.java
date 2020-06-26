package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AtendimentoEntradaDto;
import br.com.tt.petshop.dto.AtendimentoSaidaDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Atendimento;
import br.com.tt.petshop.service.AtendimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoRestController {

    private final AtendimentoService service;

    public AtendimentoRestController(AtendimentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid AtendimentoEntradaDto entradaDto){

        Atendimento atendimentoCriado = service.criar(entradaDto);

        String uri = MessageFormat.format("/atendimentos/{0}", atendimentoCriado.getId());//Mais lento.
        return ResponseEntity.created(URI.create(uri)).build();
    }

    @GetMapping
    public List<AtendimentoSaidaDto> listar(@RequestParam("pagina") int pagina,
                                            @RequestParam("tamanhoPagina") Optional<Integer> tamanhoPagina){
        return service.listar(pagina, tamanhoPagina.orElse(5));
    }
}
