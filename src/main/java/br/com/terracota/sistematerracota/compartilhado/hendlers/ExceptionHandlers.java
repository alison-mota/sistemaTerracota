package br.com.terracota.sistematerracota.compartilhado.hendlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlers {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<MensagensDeErro> interceptaMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<MensagensDeErro> mensagensDeErrosList = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            MensagensDeErro erro = new MensagensDeErro( e.getField(), mensagem, "400 Bad Request");
            mensagensDeErrosList.add(erro);
        });
        return mensagensDeErrosList;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<MensagensDeErro> interceptaResponseStatusException(ResponseStatusException ex){
        HttpStatus status = ex.getStatus();
        String localizedMessage = ex.getReason();

        MensagensDeErro response = new MensagensDeErro("Erro na requisição", localizedMessage, String.valueOf(status));

        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MensagensDeErro> interceptaHttpMessageNotReadableException(HttpMessageNotReadableException ex){

        MensagensDeErro response = new MensagensDeErro("Erro na requisição", "Data inválida", String.valueOf(HttpStatus.BAD_REQUEST));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
