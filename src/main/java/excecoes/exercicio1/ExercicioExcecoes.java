package excecoes.exercicio1;

import java.util.*;

public class ExercicioExcecoes {
    private static List<String> cidades = Arrays.asList("Porto Alegre","Curitiba","São Paulo","Rio de Janeiro","Cuiabá","São Luís");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe um numero na lista:");
        while (scanner.hasNextLine()){
            Integer posicao = null;
            try {
                posicao = scanner.nextInt();
                if(validaPosicao(posicao)) {
                    System.out.println(cidades.get(posicao));
                    break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Não foi digitado um número!");
            }
            catch (PosicaoInvalidaException e) {
                System.err.println(e.getMessage());
            }

            System.out.println("Informe um numero na lista:");
        }
    }

    private static Boolean validaPosicao(Integer posicao) {
        try {
            String cidade = cidades.get(posicao);
            return Boolean.TRUE;
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new PosicaoInvalidaException(posicao,cidades.size()-1);
        }
    }
}
