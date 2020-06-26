package br.com.tt.petshop.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UnidadeEntradaDto {

    @NotBlank(message = "Informe o nome da Unidade!")
    @Size(min = 5, max = 100)
    private String nome;

    @NotBlank(message = "Informe o endereço da unidade!")
    @Size(min = 5, max = 150)
    //@Pattern(regexp = "\\w \\w", message = "")
    private String endereco;

    public UnidadeEntradaDto(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }
}
