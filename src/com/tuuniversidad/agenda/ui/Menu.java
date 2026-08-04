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
        imprimirBannerPrincipal();
        configurarAgendaInicial();

        boolean salir = false;

        while(!salir){
            mostrarOpciones();
            int opcion = lector.leerEnteros(AZUL + "Ingresa un número del 1 al 9" + RESET);
            System.out.println(AMARILLO + "\n============================================================" + RESET);

            switch (opcion){
                case 1:
                    imprimirTituloSeccion("Añadir nuevo contacto");
                    opcionesInsertarContacto();

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
    private void imprimirBannerPrincipal() {
        System.out.println(AZUL + NEGRILLA);
        System.out.println("   ╔═══════════════════════════════════════════════════╗");
        System.out.println("   ║                                                   ║");
        System.out.println("   ║    📓  S I S T E M A   D E   A G E N D A   📓     ║");
        System.out.println("   ║                                                   ║");
        System.out.println("   ║               Versión Corporativa                 ║");
        System.out.println("   ╚═══════════════════════════════════════════════════╝");
        System.out.println(RESET);
    }
    private void configurarAgendaInicial(){
        System.out.println(CIAN +"Configuración inicial: "+ RESET);
        System.out.println("1.-Capacidad por defecto (10 contactos)");
        System.out.println("2.-Definir una capacidad de almacenamiento personalizada");

        int tipoAgenda = lector.leerEnteros(VERDE+ "Selecciona una configuración 1 o 2" + RESET);

        if (tipoAgenda==2) {
            int capacidad = lector.leerEnteros(VERDE + "Ingresa la capacidad máxima de la agenda" + RESET);
            int capacidadSegura = Math.max(1, capacidad);
            agenda = new Agenda(capacidadSegura);
            imprimirExito("Capacidad con éxito " + capacidadSegura);
        }else{
            agenda=new Agenda();
            imprimirExito("Capacidad por defecto 10 contactos");

        }

    }
    /**
     * Imprime las opciones disponibles del menú con un diseño estructurado en caja.
     */
    private void mostrarOpciones() {
        System.out.println(AZUL + "╔════════════════════ MENÚ PRINCIPAL ═════════════════════╗" + RESET);
        System.out.println(AZUL + "║" + RESET + " " + NEGRILLA + "1." + RESET + " Añadir un nuevo registro de contacto                   " + AZUL + "║" + RESET);
        System.out.println(AZUL + "║" + RESET + " " + NEGRILLA + "2." + RESET + " Verificar la existencia de un registro                 " + AZUL + "║" + RESET);
        System.out.println(AZUL + "║" + RESET + " " + NEGRILLA + "3." + RESET + " Mostrar el directorio completo de todos los contactos  " + AZUL + "║" + RESET);
        System.out.println(AZUL + "║" + RESET + " " + NEGRILLA + "4." + RESET + " Buscar la información de un contacto específico        " + AZUL + "║" + RESET);
        System.out.println(AZUL + "║" + RESET + " " + NEGRILLA + "5." + RESET + " Eliminar de forma permanente un registro de la agenda  " + AZUL + "║" + RESET);
        System.out.println(AZUL + "║" + RESET + " " + NEGRILLA + "6." + RESET + " Modificar el teléfono de un contacto existente         " + AZUL + "║" + RESET);
        System.out.println(AZUL + "║" + RESET + " " + NEGRILLA + "7." + RESET + " Consultar el estado de capacidad máxima (Llena)        " + AZUL + "║" + RESET);
        System.out.println(AZUL + "║" + RESET + " " + NEGRILLA + "8." + RESET + " Consultar la disponibilidad de los espacios libres     " + AZUL + "║" + RESET);
        System.out.println(AZUL + "║" + RESET + " " + NEGRILLA + "9." + RESET + " Finalizar y Salir del sistema                          " + AZUL + "║" + RESET);
        System.out.println(AZUL + "╚═════════════════════════════════════════════════════════╝" + RESET);
    }
    private void opcionesInsertarContacto(){
        String nombre=lector.leerCadena("▶ Ingresa el " + NEGRILLA + "nombre" + RESET + " del contacto: ");
        String apellido=lector.leerCadena("▶ Ingresa el " + NEGRILLA + "apellido" + RESET + " del contacto: ");
        String telefono=lector.leerCadena("▶ Ingresa el " + NEGRILLA + "teléfono" + RESET + " del contacto: ");

        Contacto nuevo=new Contacto(nombre,apellido,telefono);

        try{
            System.out.println(VERDE + "Procesado la solicitud de Registro"+ RESET);
            agenda.añadirContacto(nuevo);
            imprimirExito("Completado con exito"+ nombre + " "+ apellido);

        }catch (AgendaLlenaException e){
            imprimirError(e.getMessage());
            System.out.println("Sugerencia: Intenta eliminar un contacto antigüo primero");
        }catch (ContactoDuplicadoException e) {
        imprimirError(e.getMessage());
        System.out.println("  Sugerencia: Si deseas actualizar este contacto, usa la opción 6 de modificar teléfono.");
    }



    }



























    //Diseños

    private void imprimirTituloSeccion(String titulo) {
        System.out.println(CIAN + " ---> " + titulo + " <---" + RESET);
    }

    private void imprimirExito(String mensaje) {
        System.out.println(VERDE + " [✔] " + mensaje + RESET);
    }

    private void imprimirError(String mensaje) {
        System.out.println(ROJO + " [✖] ERROR: " + mensaje + RESET);
    }

    private void imprimirAlerta(String mensaje) {
        System.out.println(AMARILLO + " [!] AVISO: " + mensaje + RESET);
    }




}
