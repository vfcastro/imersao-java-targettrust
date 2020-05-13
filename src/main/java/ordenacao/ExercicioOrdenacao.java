package ordenacao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExercicioOrdenacao {
    public static void main(String[] args) {

        List<Produto> listaProdutos = Arrays.asList(
                new Produto("Creme Dental 90g", 2.49F, 2.99F),
                new Produto("Sabonete em Barra Corporal 90g", 2.99F, 3.30F),
                new Produto("Protetor Solar 30 FPS 200ml", 37.39F, 39.12F),
                new Produto("Fralda P Confort - 50 Unidades", 44.90F, 44.90F),
                new Produto("Condicionador 200ml", 18.90F, 15.00F)
        );

        // Ordem padrao (por nome)
        System.out.println("\nOrdem padrao (por nome):\n");
        Collections.sort(listaProdutos);
        for(Produto p : listaProdutos) {
            System.out.print(p.imprimeDescricao());
        }

        // Ordenana por custoAquisicao
        System.out.println("\nOrdem por custoAquisicao:\n");
        Collections.sort(listaProdutos, new ProdutoPorCustoAquisicaoComparator());
        for(Produto p : listaProdutos){
            System.out.print(p.imprimeDescricao());
        }

        // Ordenana por lucro
        System.out.print("\nOrdem por lucro:\n");
        Collections.sort(listaProdutos, new ProdutoPorLucroComparator());
        for(Produto p : listaProdutos){
            System.out.print(p.imprimeDescricao());
        }

    }
}
