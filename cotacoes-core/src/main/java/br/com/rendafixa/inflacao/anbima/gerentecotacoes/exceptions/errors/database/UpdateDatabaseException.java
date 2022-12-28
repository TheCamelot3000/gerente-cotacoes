package br.com.rendafixa.inflacao.anbima.gerentecotacoes.exceptions.errors.database;

public class UpdateDatabaseException extends RuntimeException {
    public UpdateDatabaseException(String message) {
        super(message);
    }
}
