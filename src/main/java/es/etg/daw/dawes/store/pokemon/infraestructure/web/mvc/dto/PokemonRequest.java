package es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.dto;

import es.etg.daw.dawes.store.pokemon.infraestructure.web.validation.NombradoPokemon;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PokemonRequest(
    @NotBlank (message = "{pokemon.valid.nombre.no_vacio}")
    @NombradoPokemon (message = "{pokemon.valid.nombre.nombrado_validation}")
    String nombre, 
    @NotBlank (message = "{pokemon.valid.tipo.no_vacio}")
    String tipo, String foto, 
    @Min(value=1, message = "{pokemon.valid.precio.min}")
    @Max(value = 100, message = "{pokemon.valid.precio.max}")
    double precio) {
    
}