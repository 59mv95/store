package es.etg.daw.dawes.store.pokemon.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data 
@AllArgsConstructor
@Builder 
public class Pokemon {

    // Atributos
    private int id;
    private String nombre;
    private String tipo;
    private String foto;
    private double precio;
    private LocalDateTime createdAt;
    
}