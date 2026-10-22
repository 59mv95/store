package es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.dto;

import java.time.LocalDateTime;

public record PokemonResponse(int id, String nombre, String tipo, String foto, 
    double precio, LocalDateTime createdAt ) {
    
}