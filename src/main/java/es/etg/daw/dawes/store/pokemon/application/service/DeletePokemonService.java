package es.etg.daw.dawes.store.pokemon.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.store.pokemon.application.usecase.DeletePokemonUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeletePokemonService {

    private final DeletePokemonUseCase deletePokemonUseCase;

    public void delete(int id) {
        deletePokemonUseCase.delete(id);
    }
}