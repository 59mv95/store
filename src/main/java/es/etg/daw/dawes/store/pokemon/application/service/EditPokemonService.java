
package es.etg.daw.dawes.store.pokemon.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.store.pokemon.application.command.EditPokemonCommand;
import es.etg.daw.dawes.store.pokemon.application.usecase.EditPokemonUseCase;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditPokemonService {

    private final EditPokemonUseCase editPokemonUseCase;

    public Pokemon update(EditPokemonCommand comando) {
        return editPokemonUseCase.update(comando);
    }
}