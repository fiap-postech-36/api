package br.com.nomeempresa.restaurante.exception;

public abstract class ApiErrorException extends RuntimeException {

    public abstract int getCode();
    public abstract String getMessage();

}
