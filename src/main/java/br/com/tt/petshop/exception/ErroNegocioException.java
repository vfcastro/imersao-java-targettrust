package br.com.tt.petshop.exception;

public class ErroNegocioException extends RuntimeException {

    private String codigo;
    //private String mensagem; - não precisa, eu reaproveito o do Runtime com o .getMessage()

    public ErroNegocioException(String codigo, String message) {
        super(message);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
