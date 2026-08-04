package com.sistema.agenda.excepciones;

public class ContactoDuplicadoException extends Exception {

    public ContactoDuplicadoException (String mensaje){
        super(mensaje);
    }
}
