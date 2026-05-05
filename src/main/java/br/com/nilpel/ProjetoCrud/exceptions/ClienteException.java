package br.com.nilpel.ProjetoCrud.exceptions;

public class ClienteException extends RuntimeException {
    public ClienteException(String errorDescription) {
        super(errorDescription);
    }
}