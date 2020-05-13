package excecoes.exercicio1;

public class PosicaoInvalidaException extends RuntimeException {
    public PosicaoInvalidaException() {
    }

    public PosicaoInvalidaException(int posicao, int max) {
        super(String.format("Posição %d inválida. Informe uma posição de 0 a %d\n",posicao,max));
    }
}
