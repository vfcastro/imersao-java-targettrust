package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.AnimalEntradaDto;
import br.com.tt.petshop.dto.AnimalSaidaDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<AnimalSaidaDto> buscarAnimaisPorIdCliente(Integer idCliente){
        return animalRepository.buscaAnimaisDoClientePorId(idCliente)
                .stream()
                .map(AnimalSaidaDto::new)
                .collect(Collectors.toList());
    }
}
