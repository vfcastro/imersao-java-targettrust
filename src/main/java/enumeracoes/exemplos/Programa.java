package enumeracoes.exemplos;

public class Programa {
    public static void main(String[] args) {
        String tipoPessoaInformada = "";

        if(tipoPessoaInformada == TipoPessoa.PESSOA_FISICA.name()){
        }

        TipoPessoa[] tiposPessoas = TipoPessoa.values();
        for(TipoPessoa tipo : tiposPessoas){
            System.out.println(tipo);
        }

    }
}
