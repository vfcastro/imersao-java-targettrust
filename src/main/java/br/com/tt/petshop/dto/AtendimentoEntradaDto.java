package br.com.tt.petshop.dto;

import br.com.tt.petshop.enumeration.TipoServico;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Atendimento;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AtendimentoEntradaDto {

    @NotNull
    private final TipoServico tipoServico;

    @NotBlank @Size(min = 5)
    private final String descricaoServico;

    @NotBlank @Size(min = 3)
    private final String funcionario;

    @NotNull @Positive
    private final BigDecimal valorTotal;

    @NotNull @Positive
    private final Long idAnimal;

    @JsonCreator
    public AtendimentoEntradaDto(@JsonProperty("tipoServico") TipoServico tipoServico,
                                 @JsonProperty("descricaoServico") String descricaoServico,
                                 @JsonProperty("funcionario") String funcionario,
                                 @JsonProperty("valorTotal") BigDecimal valorTotal,
                                 @JsonProperty("idAnimal") Long idAnimal) {
        this.tipoServico = tipoServico;
        this.descricaoServico = descricaoServico;
        this.funcionario = funcionario;
        this.valorTotal = valorTotal;
        this.idAnimal = idAnimal;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public Atendimento toEntity(Animal animal) {
        return new Atendimento(null,
                LocalDateTime.now(),
                tipoServico,
                descricaoServico,
                funcionario,
                valorTotal,
                animal);
    }
}
