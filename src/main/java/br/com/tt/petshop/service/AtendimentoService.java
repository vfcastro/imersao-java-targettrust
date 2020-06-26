package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.AtendimentoEntradaDto;
import br.com.tt.petshop.dto.AtendimentoSaidaDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Atendimento;
import br.com.tt.petshop.repository.AtendimentoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtendimentoService {

    private final AnimalService animalService;
    private final AtendimentoRepository repository;

    public AtendimentoService(AnimalService animalService,
                              AtendimentoRepository repository
                              ) {
        this.animalService = animalService;
        this.repository = repository;
    }

    public Atendimento criar(AtendimentoEntradaDto entradaDto) {

        //Pre-requisito
        Animal animal = animalService.buscarPorId(entradaDto.getIdAnimal());

        //Converte
        Atendimento atendimentoAserSalvo = entradaDto.toEntity(animal);

        //Salvar
        Atendimento atendimentoSalvo = repository.save(atendimentoAserSalvo);

        //retornar o atendimento salvo
        return atendimentoSalvo;
    }

    public List<AtendimentoSaidaDto> listar(int pagina, int tamanhoPagina) {

        PageRequest paginacao = PageRequest.of(pagina, tamanhoPagina);

        //Buscar os atendimentos
        return repository.findAll(paginacao)
        //Converter para dto
        .stream()
        .map(entidade -> new AtendimentoSaidaDto(entidade))
        //Retornar uma lista
        .collect(Collectors.toList());
    }

}
