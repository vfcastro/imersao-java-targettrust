package enumeracoes.exercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExercicioEnumeracoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Float rendaMensal = null;

        System.out.println("Digite a renda mensal:");
        while (scanner.hasNextLine()) {
            try {
                rendaMensal = scanner.nextFloat();
                System.out.printf("Tipo cartao: %s\n", ModalidadeCredito.tipoCartao(rendaMensal));
            } catch (InputMismatchException e) {
                System.out.println("Renda mensal inválida!");
                scanner.nextLine();
            }
            System.out.println("Digite a renda mensal:");
        }
    }
}