package br.com.tt.petshop.handler;

import br.com.tt.petshop.api.ClienteRestController;
import br.com.tt.petshop.api.UnidadeRestController;
import br.com.tt.petshop.dto.MensagemErroDto;
import br.com.tt.petshop.exception.ErroNegocioException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Diz ao Spring que deve ler Exceptions Handler dentro desta classe
@RestControllerAdvice //Se quiser para classe específica: (assignableTypes = {ClienteRestController.class, UnidadeRestController.class})
public class ErroNegocioExceptionHandler {

    @ExceptionHandler(ErroNegocioException.class)
    public ResponseEntity<MensagemErroDto> trataNegocioException(ErroNegocioException e){
        return ResponseEntity
                .unprocessableEntity()
                .body(new MensagemErroDto(e.getCodigo(), e.getMessage()));
    }
}
