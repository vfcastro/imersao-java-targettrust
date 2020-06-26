package br.com.tt.petshop.api;

import br.com.tt.petshop.model.projection.RelatorioAnimalProjection;
import br.com.tt.petshop.model.projection.RelatorioClienteProjection;
import br.com.tt.petshop.service.RelatorioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorio")
public class RelatorioRestController {

    private final RelatorioService relatorioService;

    public RelatorioRestController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping("/cliente")
    public List<RelatorioClienteProjection> listaClientes(){
        return relatorioService.listarClientes();
    }

    @GetMapping("/animal")
    public List<RelatorioAnimalProjection> listaAnimais(){
        return relatorioService.listarAnimais();
    }

}
