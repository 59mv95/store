
package es.etg.daw.dawes.store.pokemon.application.service;

import es.etg.daw.dawes.store.pokemon.application.usecase.DeletePokemonUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeletePokemonService implements DeletePokemonUseCase {

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException(
            "Hay que implementar el borrado según el repositorio del proyecto"
        );
    }
}
