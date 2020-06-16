package br.com.tt.petshop.exception;

/**
 * Comentado pois foi utilizado um ExceptionHandler no Controller do ClienteRest.
 * @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
*/
public class CpfInvalidoException extends RuntimeException {

    public CpfInvalidoException(String message) {
        super(message);
    }
}
