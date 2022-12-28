package br.com.rendafixa.inflacao.anbima.gerentecotacoes.exceptions.errors.database;

public class DeleteDatabaseException extends RuntimeException{
    public DeleteDatabaseException(String message) {
        super(message);
    }
}
