package br.com.tt.petshop.dto;

import br.com.tt.petshop.enumeration.TipoServico;
import br.com.tt.petshop.model.Atendimento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AtendimentoSaidaDto {

    private Long id;
    private LocalDateTime dataHora;
    private TipoServico tipoServico;
    private String descricaoServico;
    private String funcionario;
    private BigDecimal valorTotal;
    private AnimalSaidaDto animal;

    public AtendimentoSaidaDto(Atendimento atendimento) {
        id = atendimento.getId();
        dataHora = atendimento.getDataHora();
        tipoServico = atendimento.getTipoServico();
        descricaoServico = atendimento.getDescricaoServico();
        funcionario = atendimento.getFuncionario();
        valorTotal = atendimento.getValorTotal();
        animal = AnimalSaidaDto.build(atendimento.getAnimal());
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
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

    public AnimalSaidaDto getAnimal() {
        return animal;
    }
}
