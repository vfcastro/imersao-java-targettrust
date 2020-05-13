package ordenacao;

import java.util.Comparator;

public class ProdutoPorCustoAquisicaoComparator implements Comparator<Produto> {

    public int compare(Produto p1, Produto p2) {
        return p1.getCustoAquisicao().compareTo(p2.getCustoAquisicao());
    }
}
