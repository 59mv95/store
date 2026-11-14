package es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.dto;

import es.etg.daw.dawes.store.pokemon.infraestructure.web.validation.NombradoPokemon;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PokemonRequest(
        // El nombre no puede estar en blanco ni tener espacios/saltos de línea
    @NotBlank(message = "{pokemon.valid.nombre.no_vacio}")
    @NombradoPokemon(message = "{pokemon.valid.nombre.nombrado_validation}")
    String nombre,
        // El tipo no puede estar en blanco
    @NotBlank(message = "{pokemon.valid.tipo.no_vacio}")
    String tipo,
    String foto,
        // El precio debe estar entre 0 y 100
    @Min(value = 0, message = "{pokemon.valid.precio.min}")
    @Max(value = 100, message = "{pokemon.valid.precio.max}")
    double precio) {

}