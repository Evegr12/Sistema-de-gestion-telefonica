package com.tuuniversidad.agenda.logica;

import com.tuuniversidad.agenda.excepciones.AgendaLlenaException;
import com.tuuniversidad.agenda.excepciones.ContactoDuplicadoException;
import com.tuuniversidad.agenda.modelos.Contacto;
import java.util.Arrays;


public class Agenda {

    private Contacto[] contactos;
    private int contadorContactos;

    // Constantes para formato en los mensajes de salida (Colores ANSI)
    private static final String RESET = "\u001B[0m";
    private static final String VERDE = "\u001B[32m";
    private static final String ROJO = "\u001B[31m";
    private static final String AZUL = "\u001B[34m";
    private static final String CIAN = "\u001B[36m";



    public Agenda(){
        this(10);
    }

    /**
     * Constructor sobrecargado.
     * @param tamaño El tamaño máximo de contactos que soportará la memoria de la agenda.
     */

    public Agenda(int tamaño){
        this.contactos = new Contacto[tamaño];
        this.contadorContactos = 0;
    }


    //Métodos para añadir contacto
    public void añadirContacto(Contacto c)throws AgendaLlenaException, ContactoDuplicadoException {
        if (agendaLlena()){
            throw new AgendaLlenaException("Capacidad maxima de contactos. Tienes "+contadorContactos + " de " + contactos.length + " registros. ");
        }
        if (existeContacto(c)){
            throw new ContactoDuplicadoException("El contacto "+ c.getNombre() + " " + c.getApellido() + " ya existe en la agenda.");
        }

        for (int i=0; i<contactos.length; i++){
            if (contactos[i] == null){
                contactos[i] = c;
                contadorContactos ++;
                break;
            }
        }

    }

    public boolean existeContacto(Contacto c) {
        if (c == null) return false;
        for (int i=0; i < contactos.length; i++){
            if(contactos[i] != null && contactos[i].equals(c)){
                return true;
            }
        }
        return false;

    }


    public boolean agendaLlena(){
        return contadorContactos >= contactos.length;
    }

    public int espaciosLibres(){
        return contactos.length - contadorContactos;
    }




}
