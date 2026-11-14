# Tienda de Pokémon

Este proyecto es una aplicación web hecha con Java y Spring Boot para gestionar los Pokémon de una tienda. La hemos desarrollado en la asignatura de Desarrollo Web en Entorno Servidor (2º DAW).

Con la aplicación se pueden crear, listar, modificar y eliminar Pokémon haciendo peticiones HTTP.

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Maven
- Spring Web
- Lombok
- MapStruct
- Spring Validation
- HTML

## Arquitectura del proyecto

Para organizar el proyecto hemos usado **Clean Architecture** y **Vertical Slicing**. Esto quiere decir que el código se separa por áreas de negocio (de momento solo tenemos `pokemon`) y, dentro de cada área, por capas:

- **Domain**: es la parte más importante. Aquí está el modelo `Pokemon`, los repositorios (solo las interfaces) y las excepciones como `PokemonNotFoundException`.
- **Application**: aquí están los comandos, los casos de uso y los servicios. Es donde se ejecuta la lógica de la aplicación.
- **Infrastructure**: aquí está lo que conecta con el exterior: el controlador, los DTO, el mapper, la configuración de Spring, las validaciones y el repositorio mock.

También tenemos una carpeta **common** para las cosas que sirven para toda la aplicación, como el manejo global de errores.

### Estructura de carpetas

```
store
├── common
│   └── infraestructure/web/error
└── pokemon
    ├── domain
    │   ├── model
    │   ├── repository
    │   └── error
    ├── application
    │   ├── command
    │   ├── usecase
    │   └── service
    └── infraestructure
        ├── config
        ├── db/repository/mock
        ├── mapper
        └── web
            ├── mvc/controller
            ├── mvc/dto
            └── validation
```

### ¿Cómo funciona una petición?

Cuando el usuario hace una petición, el recorrido es este:

```
Controlador → Mapper → Servicio → Caso de uso → Repositorio
```

1. El controlador recibe los datos (`PokemonRequest`) y comprueba que son válidos.
2. El mapper convierte esos datos en un comando.
3. El servicio llama al caso de uso.
4. El caso de uso hace la lógica y usa el repositorio para guardar, buscar o borrar.
5. Al final se devuelve un `PokemonResponse` al usuario.

## Funcionalidades

| Método | Ruta | ¿Qué hace? |
|--------|------|------------|
| GET | `/pokemons` | Lista todos los Pokémon |
| POST | `/pokemons` | Crea un Pokémon nuevo |
| PUT | `/pokemons/{id}` | Modifica la foto y el precio de un Pokémon |
| DELETE | `/pokemons/{id}` | Borra un Pokémon |

### Validaciones

Cuando se crea un Pokémon se comprueba que:

- El nombre no esté vacío y no tenga espacios ni saltos de línea. Esta validación la hemos hecho nosotros con la anotación `@NombradoPokemon`.
- El tipo no esté vacío.
- El precio esté entre 0 y 100 €.

Los mensajes de error están en el fichero `messages.properties`.

### Errores

Hemos creado la clase `GlobalExceptionHandler` con `@ControllerAdvice` para controlar los errores desde un solo sitio:

- Si no se encuentra un Pokémon, se devuelve un error **404**.
- Si hay un `NullPointerException`, se devuelve un error **500**.

Así el usuario ve una página de error clara y no se muestran detalles internos del código.

### Datos

De momento no usamos base de datos. Los Pokémon se guardan en memoria con un repositorio mock que empieza con 3 Pokémon de prueba. Por eso, si se reinicia la aplicación, se pierden los cambios.

## Cómo ejecutar el proyecto

1. Clonar el repositorio.
2. Abrir una terminal en la carpeta del proyecto.
3. Ejecutar:

```sh
./mvnw spring-boot:run
```

4. Abrir en el navegador: http://localhost:8080

## Cómo probarlo

Desde el navegador:

- http://localhost:8080/pokemons → ver la lista de Pokémon
- http://localhost:8080/pokemons.html → listar, crear, editar y borrar desde una página
- http://localhost:8080/formulario-crear-pokemon.html → crear un Pokémon
- http://localhost:8080/formulario-editar-pokemon.html → editar un Pokémon
- http://localhost:8080/formulario-borrar-pokemon.html → borrar un Pokémon

También se puede probar con `curl` desde la terminal. Por ejemplo, para borrar el Pokémon con id 1:

```sh
curl -X DELETE http://localhost:8080/pokemons/1
```

## Objetivos de aprendizaje

Con esta práctica hemos aprendido a:

- Aplicar Vertical Slicing para organizar las funcionalidades según el área de negocio.
- Organizar una aplicación web con Clean Architecture.
- Crear comandos, casos de uso y servicios.
- Separar los DTO de los modelos de dominio y convertirlos con MapStruct.
- Usar repositorios para acceder a los datos.
- Gestionar las dependencias con Spring (`@Configuration` y `@Bean`).
- Validar los datos que llegan a la aplicación.
- Controlar los errores con `@ControllerAdvice`.
- Probar los endpoints desde el navegador y con `curl`.

## Mejoras pendientes

- Usar una base de datos real en lugar del repositorio mock.
- Usar plantillas HTML en lugar de escribir el HTML en el controlador.
- Añadir más áreas a la tienda, como entrenadores o ventas.