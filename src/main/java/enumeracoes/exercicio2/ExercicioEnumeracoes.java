package enumeracoes.exercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExercicioEnumeracoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TipoCartao tipoCartao = null;

        System.out.println("Digite o tipo de cartao:");
        while (scanner.hasNextLine()) {
            try {
                tipoCartao = TipoCartao.valueOf(scanner.nextLine().toUpperCase());
                System.out.printf("Taxa de juros: %s\n", TipoCartao.obterTaxaDeJurosPorTipoCartao(tipoCartao));
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo cartao inválido!");
            }
            System.out.println("Digite o tipo de cartao:");
        }
    }
}