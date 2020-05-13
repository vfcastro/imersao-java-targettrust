package enumeracoes.exercicio1;

public class ModalidadeCredito {

    public static TipoCartao tipoCartao(Float rendaMensal){
        TipoCartao tipo = null;

        if(rendaMensal < 1000){
            tipo = TipoCartao.STANDARD;
        }else if(rendaMensal < 3000){
            tipo = TipoCartao.GOLD;
        }else if(rendaMensal < 10000){
            tipo = TipoCartao.PREMIUM;
        }else if(rendaMensal >= 10000){
            tipo = TipoCartao.BLACK;
        }

        return tipo;
    }
}