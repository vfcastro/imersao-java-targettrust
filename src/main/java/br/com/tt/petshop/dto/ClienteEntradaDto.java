package br.com.tt.petshop.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClienteEntradaDto {

    @NotBlank(message = "Nome deve ser informado!")
    @Size(min = 5, max = 255, message = "Informe o nome de 5 a 255 caracteres!")
    private String nome;

    @CPF(message = "Informe um CPF válido!")
    private String cpf;

    //@Valid @NotNull
    //private UnidadeEntradaDto unidade;

    public ClienteEntradaDto(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome.replaceAll("[^\\w]", " ")
                .replaceAll("[ ]{2,}", " ");
    }

    public String getNomeOriginal(){
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
