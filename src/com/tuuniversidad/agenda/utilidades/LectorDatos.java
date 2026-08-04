package com.tuuniversidad.agenda.utilidades;

import java.util.Scanner;

public class LectorDatos {
    private Scanner scanner;

    public LectorDatos(){
        this.scanner = new Scanner(System.in);
    }

    //metodo para leer cadenas

    public String leerCadena(String mensaje){
        System.out.print(mensaje);
        return scanner.nextLine().trim();

    }

    public int leerEnteros(String mensaje){
        int numero = 0;
        boolean valido = false;

        while (!valido){
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(scanner.nextLine().trim());
                valido = true;
            }catch (NumberFormatException e){
                System.out.println("Error! debe ingresar un número entero");
            }
        }
        return numero;
    }

    public void cerrar(){
        if (scanner != null){
            scanner.close();
        }
    }
}
