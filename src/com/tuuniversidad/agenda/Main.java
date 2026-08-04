package com.tuuniversidad.agenda;

import com.tuuniversidad.agenda.ui.Menu;
import com.tuuniversidad.agenda.ui.CLI;

public class Main {
    public static void main(String[] args) {
        // Validamos si el usuario ingresó comandos desde la terminal al ejecutar el archivo
        if (args.length > 0) {
            // Modo CLI (Command Line Interface)
            CLI consolaExterna = new CLI();
            consolaExterna.procesarArgumentos(args);
        } else {
            // Modo Interactivo (Menú visual en consola)
            Menu menuAgenda = new Menu();
            menuAgenda.iniciar();
        }
    }
}
