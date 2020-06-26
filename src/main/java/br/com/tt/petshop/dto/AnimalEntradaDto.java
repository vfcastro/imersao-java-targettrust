package br.com.tt.petshop.dto;

import br.com.tt.petshop.enumeration.TipoAnimal;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class AnimalEntradaDto {

    @NotBlank(message = "É necessário informar o nome!")
    @Size(min = 3, max = 20, message = "O nome deve conter de 3 a 20 caracteres")
    private String nome;

    @PastOrPresent(message = "A data de nascimento deve ser passada!")
    private LocalDate dataNascimento;

    @NotNull(message = "Informe um dos tipos: MAMIFERO, REPTIL ou PEIXE")
    private TipoAnimal tipo;


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
