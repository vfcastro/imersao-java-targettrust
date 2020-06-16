package br.com.tt.petshop.dto;

import br.com.tt.petshop.enumeration.TipoAnimal;

import java.time.LocalDate;

public class AnimalEntradaDto {
    private String nome;
    private LocalDate dataNascimento;
    private TipoAnimal tipo;

    public AnimalEntradaDto(String nome,
                            LocalDate dataNascimento,
                            TipoAnimal tipo) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }
}
