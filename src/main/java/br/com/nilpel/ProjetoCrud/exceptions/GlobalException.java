package br.com.nilpel.ProjetoCrud.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.nilpel.ProjetoCrud.model.Excecao;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalException {


  @ExceptionHandler(ClienteException.class)
  public ResponseEntity<Excecao> clienteException(ClienteException e, HttpServletRequest request) {
    Excecao err = new Excecao();
    err.setDate(LocalDateTime.now());
    err.setErrorCode(HttpStatus.BAD_REQUEST.value());
    err.setErrorDescription("Ocorreu um erro no cliente.");
    err.setErrorMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
  }
    
}
