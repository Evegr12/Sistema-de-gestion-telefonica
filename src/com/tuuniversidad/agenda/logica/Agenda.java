package com.tuuniversidad.agenda.logica;
import com.tuuniversidad.agenda.excepciones.AgendaLlenaexception;
import com.tuuniversidad.agenda.excepciones.ConctactoDuplicadoException;
import com.tuuniversidad.agenda.modelos.Contacto;


public class Agenda {

    private Contacto[] contactos;
    private int contadorContactos;

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

    //Metodo para añadir contacto
    public void añadirContacto(Contacto c)throws AgendaLlenaexception, ConctactoDuplicadoException {
        if (agendaLlena()) {
            throw new AgendaLlenaexception("");
        }
        
    }

}
