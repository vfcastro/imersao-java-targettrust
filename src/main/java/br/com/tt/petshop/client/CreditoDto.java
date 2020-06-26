package br.com.tt.petshop.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditoDto {
    private String situacao;
    private Integer pontos;

    @JsonCreator
    public CreditoDto(@JsonProperty("situacao") String situacao,
                      @JsonProperty("pontos") Integer pontos) {
                    //@JsonProperty("pontos") @JsonAlias("pontos-credito") Integer pontos) {
        this.situacao = situacao;
        this.pontos = pontos;
    }

    public boolean isNegativado(){
        return situacao!= null && "NEGATIVADO".equalsIgnoreCase(situacao);
    }

    public String getSituacao() {
        return situacao;
    }

    public Integer getPontos() {
        return pontos;
    }
}
