package br.com.adatech.billboardsongs.infra.banco.exception;

public class DatabaseException extends Exception {

    public DatabaseException(String message) {
        super(message);
    }
}
