package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/unidade")
public class UnidadeController {

    private UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService){
        this.unidadeService = unidadeService;
    }

    @RequestMapping("lista")
    public String getUnidadeLista(Model model){

        System.out.println("Chamei o controller!!!"+this);

        List<UnidadeDto> unidades = unidadeService.listarUnidades();
        model.addAttribute("unidades", unidades);

        return "unidade_lista";
    }

    @RequestMapping("cadastro")
    public String getPaginaCadastro(){
        return "unidade_cadastro";
    }

    //Action - POST - receber dados (nome, endereco)
    @RequestMapping("acaoCadastrar")
    public ModelAndView acaoCadastrar(@RequestParam("nome")     String nome,
                                      @RequestParam("endereco") String endereco){

        UnidadeDto unidadeDto = new UnidadeDto(null, nome, endereco);
        unidadeService.criarUnidade(unidadeDto);
        return new ModelAndView("unidade_cadastro");
    }

}
