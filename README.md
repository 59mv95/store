# Tienda de Pokemon

Desarrollo de una aplicación con Java y SpringBoot para gestionar Pokémon de una tienda. 

Esta aplicación permite crear, listar, modificar y eliminar Pokémon mediante peticiones HTTP.

## Tecnologías utilizadas

· Java 17
· SpringBoot
· Maven
· Spring Web
· Lombok
· HTML

## Arquitectura del proyecto

Este proyecto utiliza Clean Architecture y Vertical Slicing, y la funcionalidad de Pokémon la organizamos en estas tres capas principales:

· Domain: contiene el modelo de negocio y las entidades.
· Application: contiene los comandos, los casos de uso y los servicios, que son los que van a ejecutar la lógica de la aplicación.
· Infrastructure: contiene los controladores web, los mapper, la configuración de Spring y los DTO.

## Objetivos de aprendizaje

Con esta práctica se pretende:

· Saber aplicar Vertical Slicing para organizar funcionalidades según el área de negocio
· Saber que casos de uso y servicios de la aplicación crear.
· Separar los DTO de los modelos de dominio.
· Probar endpoints junto al navegador y viendo como se ejecuta el código según avanzamos.
· Gestionar dependencias mediante Spring 
· Comprender la organización de nuestra aplicación web con Clean Architecture.