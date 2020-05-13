package ordenacao;

import java.util.Comparator;

public class ProdutoPorLucroComparator implements Comparator<Produto> {

    public int compare(Produto p1, Produto p2) {
            Float lucroP1 = p1.calculaLucro();
            Float lucroP2 = p2.calculaLucro();
            return lucroP1.compareTo(lucroP2);
    }
}