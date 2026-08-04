package com.sistema.agenda.logica;

import com.sistema.agenda.excepciones.AgendaLlenaException;
import com.sistema.agenda.excepciones.ContactoDuplicadoException;
import com.sistema.agenda.modelos.Contacto;
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

    //Listar contacto
    public void listarContactos(){
        if (contadorContactos == 0 ){
            System.out.println(ROJO + "No hay contactos registrados." + RESET);
            return;
        }
        System.out.println(AZUL + " ┌──────────────────────────────────────────────────────────────┐" + RESET);
        System.out.println(AZUL + " │" + CIAN + "                   DIRECTORIO DE CONTACTOS                    " + AZUL + "│" + RESET);
        System.out.println(AZUL + " ├──────────────────────────────────────────────────────────────┤" + RESET);

        int mostrados = 0;
        for (int i = 0; i < contactos.length; i++){

            if ( contactos[i] != null){
                mostrados ++;
                System.out.printf(AZUL + " │ " + RESET + "Registro #%02d -> %-41s" + AZUL + "│\n" + RESET, mostrados, contactos[i].toString());

            }


        }
        System.out.println(AZUL + " └──────────────────────────────────────────────────────────────┘" + RESET);
        System.out.println(VERDE + "   Total listados satisfactoriamente: " + mostrados + " (Capacidad máxima: " + contactos.length + ")" + RESET);

    }

    //Buscar contacto
    public void buscarContacto(String nombre, String apellido){

        Contacto contactoTemporal = new Contacto(nombre, apellido, "");
        Boolean encontrado = false;

        for (int i = 0; i < contactos.length; i++){

            if ( contactos[i] != null && contactos[i].equals(contactoTemporal)){

                System.out.println(VERDE + " [✔] ¡Búsqueda en directorio finalizada con éxito!" + RESET);
                System.out.println("     ---------------------------------------------");
                System.out.println("     Dato almacenado: " + contactos[i].toString());
                System.out.println("     Ubicación física en memoria: Índice [" + i + "] de la matriz.");
                System.out.println("     ---------------------------------------------");
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            System.out.println(ROJO + " [✖] Fallo en la búsqueda: No se han encontrado coincidencias para '" + nombre + " " + apellido + "'." + RESET);
        }


    }

    //Eliminar contacto

    public void eliminarContacto(Contacto c){
        Boolean eliminado = false;

        for (int i = 0; i < contactos.length; i++){
            if ( contactos[i] != null && contactos[i].equals(c)){
                contactos[i] = null;
                contadorContactos --;
                eliminado = true;
                break;
            }
        }
        if (eliminado) {
            System.out.println(VERDE + " [✔] Confirmación: El registro ha sido erradicado permanentemente de la base de datos." + RESET);
        } else {
            System.out.println(ROJO + " [✖] Operación fallida: El sistema no pudo localizar el contacto especificado para su borrado." + RESET);
        }

    }

    //Modificar telefono

    public void modificarTelefono(String nombre, String apellido, String newNumero){

        Contacto contactoTemporal = new Contacto(nombre, apellido, "");
        boolean modificado = false;

        for (int i = 0; i < contactos.length; i++){

            if ( contactos[i] != null && contactos[i].equals(contactoTemporal)){

                contactos[i].setTelefono(newNumero);
                modificado = true;
                System.out.println(VERDE + "[✔] El numero de contacto se actualizó correctamente para: "+ nombre + " " + apellido + "'." + RESET);

                break;
            }

        }
        if (!modificado) {
            System.out.println(ROJO + " [✖] Operación fallida: El sistema no pudo localizar el contacto especificado para su modificación." + RESET);
        }
        



    }

    //Metodo de agenda llena
    public boolean agendaLlena(){
        return contadorContactos >= contactos.length;
    }

    //Metodo de espacios libres en memoria
    public int espaciosLibres(){
        return contactos.length - contadorContactos;

    }







}
