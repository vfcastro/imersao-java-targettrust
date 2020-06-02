package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller // Eles são SINGLETON - É Única na memória
public class InicialController {

    //@Autowired //não recomendo o uso - use construtor no lugar
    // - Testes - Ter de fazer injeção de atributos privados
    // - Performance - busca dos campos para injeção.
    // - Bad Smell - não deixa tão explicita a quantidade de dependências que vocẽ tem.
    //private UnidadeService unidadeService;

    public InicialController(UnidadeService unidadeService){
        //this.unidadeService = unidadeService;
        System.out.println("Inicie o controller!!!"+this);
    }

    @RequestMapping("/admin")
    public String getPaginaInicial(){
        return "pagina_inicial";
    }
}
