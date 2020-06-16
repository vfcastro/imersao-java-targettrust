package br.com.tt.petshop.dto;

import br.com.tt.petshop.enumeration.TipoAnimal;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;

import java.time.LocalDate;

public class AnimalSaidaDto {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private TipoAnimal tipo;

    public AnimalSaidaDto(Animal animal){
        this.id = animal.getId();
        this.nome = animal.getNome();
        this.dataNascimento = animal.getDataNascimento();
        this.tipo = animal.getTipo();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public TipoAnimal getTipo() { return tipo; }
}
