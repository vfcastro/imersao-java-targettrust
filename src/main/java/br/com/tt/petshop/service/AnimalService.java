package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.AnimalEntradaDto;
import br.com.tt.petshop.dto.AnimalSaidaDto;
import br.com.tt.petshop.dto.ClienteEntradaDto;
import br.com.tt.petshop.enumeration.TipoAnimal;
import br.com.tt.petshop.exception.ErroNegocioException;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.AnimalRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    //Você pode injetar tanto classes quanto interfaces
    // (desde que as interfaces tenham uma implementação)
    // Neste caso o Spring irá criar essa implementação EM RUNTIME.
    private final AnimalRepository animalRepository;
    private final ClienteService clienteService;

    public AnimalService(AnimalRepository animalRepository, ClienteService clienteService) {
        this.animalRepository = animalRepository;
        this.clienteService = clienteService;
    }

    public void removerAnimal(Long idAnimal){
        animalRepository.deleteById(idAnimal);
    }

    public void removerAnimalComValidacao(Long idAnimal){
        animalRepository.findById(idAnimal)
                .ifPresentOrElse( animal -> animalRepository.delete(animal),
                () -> {throw new RuntimeException("Animal não existe");});
    }

    public Animal criarAnimal(AnimalEntradaDto animalDto, Integer idCliente){
        Cliente clienteDonoDoAnimal = clienteService.buscarPorId(idCliente);

        Animal animal = new Animal(animalDto, clienteDonoDoAnimal);
        return animalRepository.save(animal);
    }

    public List<Animal> buscarPorNomeENascimento(String nome, LocalDate dataNascimento){
        return animalRepository.findByNomeAndDataNascimentoOrderByNome(nome, dataNascimento);
    }


    public List<AnimalSaidaDto> listar(TipoAnimal tipo, Integer idCliente) {

        //List<Animal> animais = animalRepository.findAll(Example.of(new Animal(dtoFiltro)));

        List<Animal> animais;
        if(tipo != null){
            animais = animalRepository.findByClienteIdAndTipo(idCliente, tipo);
        }else{
            //animais = animalRepository.findByClienteId(idCliente);
            animais = animalRepository.buscarPorClienteId(idCliente);
        }

        //Converter os animais em AnimalDto
        return animais.stream()
                .map(AnimalSaidaDto::build)
                .collect(Collectors.toList());

//        List<AnimalSaidaDto> animaisDto = new ArrayList<>();
//
//        for (Animal animal : animais){
//            animaisDto.add(new AnimalSaidaDto(animal));
//        }
//
//        return animaisDto;
    }

    public Animal buscarPorId(Long idAnimal) {
        return animalRepository
                .findById(idAnimal)
                .orElseThrow(() -> new ErroNegocioException("animal_inexistente", "Animal inexistente!"));
    }
}
