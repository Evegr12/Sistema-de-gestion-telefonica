package com.tuuniversidad.agenda.modelos;

import java.util.Objects;

public class Contacto {

    //ATRIBUTOS DE CONTACTO
   private String nombre;
   private String apellido;
   private String telefono;

   //Constructor

    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    //METODO GET Y SET

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //validamos requisito cuando un contacto es igual a otro o cuando sus nombres son iguales
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass()) //validacion de seguridad a objetos vacios
            return false;
        Contacto contacto = (Contacto) obj;
        return nombre.equalsIgnoreCase(contacto.nombre) && apellido.equalsIgnoreCase(contacto.apellido);
    }

    //Metodo para convertir el nombre a minuscula
    @Override
    public int hashCode(){
        return Objects.hash(nombre.toLowerCase(),apellido.toLowerCase());
    }

    //METODO toString
    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido + " Teléfono: " + telefono;
    }
}
