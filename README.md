<div align="center">

# Sistema de gestión telefónica

Aplicación de consola desarrollada en Java para registrar y administrar contactos telefónicos.

![Java](https://img.shields.io/badge/Java-8E44AD?style=flat-square\&logo=openjdk\&logoColor=white)
![POO](https://img.shields.io/badge/POO-C2185B?style=flat-square)
![Git](https://img.shields.io/badge/Git-6F42C1?style=flat-square\&logo=git\&logoColor=white)

</div>

---

## Descripción

Sistema desarrollado durante un hackathon colaborativo para gestionar una agenda telefónica desde la consola.

El proyecto aplica programación orientada a objetos, arreglos, validación de datos, manejo de excepciones y organización del código por paquetes.

## Funcionalidades

* Agregar contactos.
* Consultar si un contacto existe.
* Mostrar todos los contactos.
* Buscar contactos por nombre.
* Eliminar contactos.
* Consultar espacios disponibles.
* Validar datos ingresados por el usuario.
* Controlar contactos duplicados y agenda llena.

## Tecnologías

* Java.
* Programación orientada a objetos.
* Arreglos.
* Excepciones personalizadas.
* Git y GitHub.

## Estructura del proyecto

```text
src/
└── com/
    └── sistema/
        └── agenda/
            ├── modelos/
            │   └── Contacto.java
            ├── logica/
            │   └── Agenda.java
            ├── excepciones/
            │   ├── AgendaLlenaException.java
            │   └── ContactoDuplicadoException.java
            ├── utilidades/
            │   └── LectorDatos.java
            ├── ui/
            │   └── Menu.java
            └── Main.java
```

| Archivo                           | Descripción                                                                |
| --------------------------------- | -------------------------------------------------------------------------- |
| `Contacto.java`                   | Representa un contacto con su nombre y número telefónico.                  |
| `Agenda.java`                     | Contiene la lógica para agregar, buscar, listar y eliminar contactos.      |
| `AgendaLlenaException.java`       | Controla el error que ocurre cuando no hay espacio para más contactos.     |
| `ContactoDuplicadoException.java` | Controla el intento de registrar un contacto que ya existe.                |
| `LectorDatos.java`                | Lee y valida los datos ingresados por el usuario en la consola.            |
| `Menu.java`                       | Muestra las opciones disponibles y gestiona la interacción con el usuario. |
| `Main.java`                       | Inicia la aplicación y ejecuta el menú principal.                          |


## Ejecución

### Requisitos

* Java JDK 17 o superior.
* Git.
* Un IDE compatible con Java.

### Clonar el repositorio

```bash
git clone https://github.com/Evegr12/Sistema-de-gestion-telefonica.git
cd Sistema-de-gestion-telefonica
```

Abre el proyecto en tu IDE y ejecuta:

```text
src/com/sistema/agenda/Main.java
```

## Trabajo colaborativo

El proyecto fue desarrollado por un equipo de seis integrantes mediante ramas individuales e integración de cambios con Git y GitHub.

[Ver colaboradores](https://github.com/Evegr12/Sistema-de-gestion-telefonica/graphs/contributors)
