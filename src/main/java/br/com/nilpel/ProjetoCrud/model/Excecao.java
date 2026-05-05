package br.com.nilpel.ProjetoCrud.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Excecao {

    private int errorCode;
    private String errorMessage;
    private String errorDescription;
    private String path;
    private LocalDateTime date;
}