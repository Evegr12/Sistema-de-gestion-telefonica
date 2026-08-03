package com.tuuniversidad.agenda.ui;

import com.tuuniversidad.agenda.logica.Agenda;
import com.tuuniversidad.agenda.utilidades.LectorDatos;

public class Menu {


    private Agenda agenda;
    private LectorDatos lector;


    // Constantes para colores y formatos (ANSI Escape Codes)
    private static final String RESET = "\u001B[0m";
    private static final String AZUL = "\u001B[34m";
    private static final String VERDE = "\u001B[32m";
    private static final String ROJO = "\u001B[31m";
    private static final String AMARILLO = "\u001B[33m";
    private static final String CIAN = "\u001B[36m";
    private static final String NEGRILLA = "\u001B[1m";

    public Menu(){
        this.lector = new LectorDatos();
    }

    public void iniciar(){
        boolean salir = false;

        while(!salir){
            int opcion = lector.leerEnteros(AZUL + "Ingresa un número del 1 al 9" + RESET);
            System.out.println(AMARILLO + "\n============================================================" + RESET);

            switch (opcion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                default:
            }
            System.out.println(AMARILLO + "\n============================================================" + RESET);
        }
        lector.cerrar();

    }


}
