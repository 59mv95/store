package es.etg.daw.dawes.store.pokemon.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.store.pokemon.application.command.CreatePokemonCommand;
import es.etg.daw.dawes.store.pokemon.application.usecase.CreatePokemonUseCase;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class CreatePokemonService {
    
    private final CreatePokemonUseCase createPokemonUseCase;

    public Pokemon createPokemon(CreatePokemonCommand comando){
        Pokemon pokemon = createPokemonUseCase.create(comando);
        return pokemon;
    }
}