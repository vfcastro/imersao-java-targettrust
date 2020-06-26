package br.com.tt.petshop.model;

import br.com.tt.petshop.enumeration.TipoServico;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TB_ATENDIMENTO")
public class Atendimento {

    Atendimento(){
    }

    public Atendimento(Long id,
                       LocalDateTime dataHora,
                       TipoServico tipoServico,
                       String descricaoServico,
                       String funcionario,
                       BigDecimal valorTotal,
                       Animal animal) {
        this.id = id;
        this.dataHora = dataHora;
        this.tipoServico = tipoServico;
        this.descricaoServico = descricaoServico;
        this.funcionario = funcionario;
        this.valorTotal = valorTotal;
        this.animal = animal;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dataHora")
    @NotNull @PastOrPresent
    private LocalDateTime dataHora;

    @Column(name = "tipoServico")
    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoServico tipoServico;

    @Column(name = "descricaoServico")
    @NotBlank
    private String descricaoServico;

    @Column(name = "funcionario")
    @NotBlank
    private String funcionario;

    @Column(name = "valorTotal")
    @Positive
    private BigDecimal valorTotal;

    //@OneToOne/@OneToMany/@ManyToMany
    //Eager -> faz select e traz junto / Lazy -> deixa pra trazar quando você pede!
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ANIMAL")
    @NotNull
    private Animal animal;

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

    public Animal getAnimal() {
        return animal;
    }
}
