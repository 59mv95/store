
package es.etg.daw.dawes.store.pokemon.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditPokemonCommand {

    private int id;
    private String foto;
    private double precio;
}
