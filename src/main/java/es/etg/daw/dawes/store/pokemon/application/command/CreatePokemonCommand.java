package es.etg.daw.dawes.store.pokemon.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

//Esta clase tiene los datos necesarios para crear un Pokemon
@Getter
@AllArgsConstructor
@Accessors(fluent = true) // Así los getters no llevan prefijo get
public class CreatePokemonCommand {
    
    private String nombre;
    private String tipo;
    private String foto;
    private double precio;
}