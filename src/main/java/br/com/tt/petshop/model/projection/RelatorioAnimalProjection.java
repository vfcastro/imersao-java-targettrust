package br.com.tt.petshop.model.projection;

import br.com.tt.petshop.enumeration.TipoAnimal;

import java.time.LocalDate;

public interface RelatorioAnimalProjection {
    String getNome();
    LocalDate getDataNascimento();
    TipoAnimal getTipo();
    String getNomeCliente();
    String getCpfCliente();
}
