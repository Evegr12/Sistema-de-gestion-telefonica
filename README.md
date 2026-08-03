# Agenda-Project

Este proyecto es un sistema interactivo en consola desarrollado en Java para gestionar una agenda telefónica. Permite administrar contactos y realizar diversas operaciones sobre ellos mediante un menú de usuario.

## Características

El sistema cuenta con las siguientes funcionalidades:

- **Añadir un contacto:** Permite agregar un nuevo contacto asegurando que no haya nombres duplicados. Si la agenda está llena, se notificará al usuario.
- **Verificar si existe:** Comprueba si un contacto ya existe en la agenda buscando por su nombre.
- **Listar contactos:** Muestra en pantalla todos los contactos guardados actualmente.
- **Buscar contacto:** Busca un contacto específico por su nombre y muestra su número de teléfono.
- **Eliminar contacto:** Elimina un contacto de la agenda e indica por pantalla si la operación fue exitosa.
- **Estado de la agenda:** Indica si la agenda se encuentra llena.
- **Espacios libres:** Muestra cuántos contactos más se pueden seguir agregando.

## Estructura del Proyecto

```text
Agenda-Project/
├── src/
│   └── com/tuuniversidad/agenda/
│       ├── modelos/
│       │   └── Contacto.java               # Define un contacto (nombre, teléfono).
│       ├── logica/
│       │   └── Agenda.java                 # Gestiona el arreglo de contactos y la lógica de negocio.
│       ├── excepciones/                    # (NUEVO) Manejo robusto de errores
│       │   ├── AgendaLlenaException.java
│       │   └── ContactoDuplicadoException.java
│       ├── utilidades/                     # (NUEVO) Clases de apoyo
│       │   └── LectorDatos.java            # Para validar y leer la entrada del usuario por consola sin que el programa colapse.
│       ├── ui/                             # (NUEVO) Capa de presentación
│       │   └── Menu.java                   # Contiene toda la lógica visual (textos) del menú y el switch/case.
│       └── Main.java                       # Punto de entrada. Solo llama a la inicialización de la UI.
├── test/                                   # (NUEVO) Preparado para futuras pruebas unitarias.
├── README.md                               # Documentación del proyecto.
└── .gitignore                              # Archivos ignorados por Git.
```

## Cómo ejecutarlo

1. Asegúrate de tener **Java (JDK)** instalado en tu computadora.
2. Abre una terminal en la ruta principal del proyecto (`Agenda-Project`).
3. Compila el código fuente (los archivos compilados irán a una carpeta `bin`):
   ```bash
   mkdir bin
   javac -d bin src/com/tuuniversidad/agenda/**/*.java src/com/tuuniversidad/agenda/*.java
   ```
4. Ejecuta el programa principal:
   ```bash
   java -cp bin com.tuuniversidad.agenda.Main
   ```
