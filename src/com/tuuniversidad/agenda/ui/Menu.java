package com.tuuniversidad.agenda.ui;

import com.tuuniversidad.agenda.logica.Agenda;
import com.tuuniversidad.agenda.modelos.Contacto;
import com.tuuniversidad.agenda.utilidades.LectorDatos;
import com.tuuniversidad.agenda.excepciones.AgendaLlenaException;
import com.tuuniversidad.agenda.excepciones.ContactoDuplicadoException;

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
            int opcion = lector.leerEnteros(AZUL + "Ingresa un número del 1 al 9: " + RESET);
            System.out.println(AMARILLO + "\n============================================================" + RESET);

            switch (opcion){
                case 1:
                    imprimirTituloSeccion("Añadir nuevo contacto");
                    opcionesInsertarContacto();
                    break;
                case 2:
                    imprimirTituloSeccion("Verifica si ya existe un contacto");
                    opcionExisteContacto();
                    break;
                case 3:
                    imprimirTituloSeccion("Lista completa de tus contactos");
                    opcionListaContactos();
                    break;
                case 4:
                    imprimirTituloSeccion("Busca un contacto");
                    opcionBuscarContacto();
                    break;
                case 5:
                    imprimirTituloSeccion("Elimina un contacto");
                    opcionEliminarContacto();
                    break;
                case 6:
                    imprimirTituloSeccion("Actualiza un teléfono");
                    opcionModificarTelefono();
                    break;
                case 7:
                    imprimirTituloSeccion("Estado de capacidad (lleno)");
                    opcionAgendaLlena();
                    break;
                case 8:
                    imprimirTituloSeccion("Estado de capacidad (espacios libres)");
                    opcionEspaciosLibres();
                    break;
                case 9:
                    System.out.println("Salir");
                    salir = true;
                    System.out.println(VERDE + "Saliendo del programa" + RESET);
                    break;
                default:
                    imprimirError("Esa opción no es válida. Elige un número del 1 al 9.");
            }
            System.out.println(AMARILLO + "\n============================================================" + RESET);
        }
        lector.cerrar();

    }

    //Metodo para imrpimir el banner principal aesthetic
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

    //Metodo para configurar el almacenamiento de la agenda
    private void configurarAgendaInicial(){
        System.out.println(CIAN +"Configuración inicial: "+ RESET);
        System.out.println("1.-Capacidad por defecto (10 contactos)");
        System.out.println("2.-Definir una capacidad de almacenamiento personalizada");

        int tipoAgenda = lector.leerEnteros(VERDE+ "Selecciona una configuración 1 o 2: " + RESET);

        if (tipoAgenda==2) {
            int capacidad = lector.leerEnteros(VERDE + "Ingresa la capacidad máxima de la agenda: " + RESET);
            int capacidadSegura = Math.max(1, capacidad);
            agenda = new Agenda(capacidadSegura);
            imprimirExito("Capacidad con éxito " + capacidadSegura);
        }else{
            agenda=new Agenda();
            imprimirExito("Capacidad por defecto 10 contactos.");

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

    //Metodo para Insertar un contacto
    private void opcionesInsertarContacto(){
        String nombre=lector.leerCadena("▶ Ingresa el " + NEGRILLA + "nombre" + RESET + " del contacto: ");
        String apellido=lector.leerCadena("▶ Ingresa el " + NEGRILLA + "apellido" + RESET + " del contacto: ");
        String telefono=lector.leerCadena("▶ Ingresa el " + NEGRILLA + "teléfono" + RESET + " del contacto: ");

        Contacto nuevo=new Contacto(nombre,apellido,telefono);

        try{
            System.out.println(VERDE + "Procesando la solicitud de Registro"+ RESET);
            agenda.añadirContacto(nuevo);
            imprimirExito("Completado con éxito "+ nombre + " "+ apellido);

        }catch (AgendaLlenaException e){
            imprimirError(e.getMessage());
            System.out.println("Sugerencia: Intenta eliminar un contacto antigüo primero.");
        }catch (ContactoDuplicadoException e) {
        imprimirError(e.getMessage());
        System.out.println("  Sugerencia: Si deseas actualizar este contacto, usa la opción 6 de modificar teléfono.");
    }
    }

    //Metodo para verificar si existe un contacto 'opción existe contacto'
    private void opcionExisteContacto(){
        String nombre = lector.leerCadena("▶ Ingresa el nombre exacto del contacto: ");
        String apellido = lector.leerCadena("▶ Ingresa el apellido exacto del contacto: ");

        Contacto temp = new Contacto(nombre, apellido, "");
        System.out.println(AZUL + "Buscando..." + RESET);

        if (agenda.existeContacto(temp)){
            imprimirExito("Confirmado: el contacto " + nombre + " " + apellido + " sí existe.");
        } else {
            imprimirAlerta("el contacto " + nombre + " " + apellido + " no existe.");
        }
    }

    //Metodo para traer la lista completa de contactos
    private void opcionListaContactos(){
        agenda.listarContactos();
    }

    //Metodo para buscar un contacto
    private void opcionBuscarContacto(){
        String nombre = lector.leerCadena("▶ Ingresa el nombre del contacto que quieres buscar: ");
        String apellido = lector.leerCadena("▶ Ingresa el apellido del contacto: ");

        System.out.println(AZUL + "Buscando datos..." + RESET);

        agenda.buscarContacto(nombre, apellido);
    }

    //Metodo para eliminar un contacto
    private void opcionEliminarContacto(){
        String nombre = lector.leerCadena("▶ Ingresa el nombre del elemento a eliminar permanentemente: ");
        String apellido = lector.leerCadena("▶ Ingresa el apellido del contacto a eliminar permanentemente: ");

        String confirmacion = lector.leerCadena( ROJO + "¿Seguro que quieres eliminar el contacto " + nombre + " " + apellido + "? Si/No " + RESET);
        if (confirmacion.equalsIgnoreCase("Si") || confirmacion.equalsIgnoreCase("S")){
            System.out.println(AZUL + "Eliminando..." + RESET);
            Contacto temporal = new Contacto(nombre, apellido, "");
            agenda.eliminarContacto(temporal);
        } else {
            imprimirAlerta("No se eliminó el contacto.");
        }
    }

    //Metodo para modificar teléfono
    private void opcionModificarTelefono(){
        String nombre = lector.leerCadena("▶ Ingresa el nombre del elemento cuyo teléfono quieres cambiar: ");
        String apellido = lector.leerCadena("▶ Ingresa el apellido del contacto: ");
        String nuevoTelefono = lector.leerCadena("Ingresa el nuevo teléfono que tendrá este contacto: ");

        System.out.println(AZUL + "Actualizando el número..."+ RESET);

        agenda.modificarTelefono(nombre, apellido, nuevoTelefono);
    }

    //Metodo para revisar si el almacenamiento está lleno
    private void opcionAgendaLlena(){
        System.out.println(AZUL + "Analizando el almacenamiento..." + RESET);
        if (agenda.agendaLlena()){
            imprimirError("El espacio de almacenamiento de la agenda está lleno.");
        } else {
            System.out.println(VERDE + "Todavía tienes espacio de almacenamiento." + RESET);
        }
    }

    //Metodo para revisar si hay espacios libres en el almacenamiento
    private void opcionEspaciosLibres(){
        System.out.println(AZUL + "Analizando el almacenamiento libre..." + RESET);
        int espacioVacio = agenda.espaciosLibres();
        imprimirExito("Tienes " + espacioVacio + " espacios disponibles en tu agenda.");
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
