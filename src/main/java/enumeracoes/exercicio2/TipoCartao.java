package enumeracoes.exercicio2;

public enum TipoCartao {
    STANDARD(3.05F),
    GOLD(3.05F),
    PREMIUM(2.95F),
    BLACK(1.98F);

    private Float taxaDeJuros;

    TipoCartao(Float taxaDeJuros){
        this.taxaDeJuros = taxaDeJuros;
    }

    public static Float obterTaxaDeJurosPorTipoCartao(TipoCartao tipoCartao){
        Float taxaDeJuros = null;

        for(TipoCartao tipo : TipoCartao.values()){
            if(tipo.equals(tipoCartao)){
                taxaDeJuros = tipo.taxaDeJuros;
                break;
            }
        }

        if(taxaDeJuros == null){
            throw new RuntimeException(String.format("Não há taxa de juros configurada para cartao tipo %s",tipoCartao.name()));
        }

        return taxaDeJuros;
    }
}