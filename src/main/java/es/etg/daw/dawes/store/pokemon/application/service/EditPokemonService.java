
package es.etg.daw.dawes.store.pokemon.application.service;

import es.etg.daw.dawes.store.pokemon.application.command.EditPokemonCommand;
import es.etg.daw.dawes.store.pokemon.application.usecase.EditPokemonUseCase;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import org.springframework.stereotype.Service;

@Service
public class EditPokemonService implements EditPokemonUseCase {

    @Override
    public Pokemon update(EditPokemonCommand command) {
        throw new UnsupportedOperationException(
            "Hay que implementar la actualización según el repositorio del proyecto"
        );
    }
}
