package es.etg.daw.dawes.store.pokemon.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.store.pokemon.application.service.CreatePokemonService;
import es.etg.daw.dawes.store.pokemon.application.service.FindPokemonService;
import es.etg.daw.dawes.store.pokemon.application.usecase.CreatePokemonUseCase;
import es.etg.daw.dawes.store.pokemon.application.usecase.FindPokemonUseCase;
import es.etg.daw.dawes.store.pokemon.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;

@Configuration 
@RequiredArgsConstructor 
public class PokemonConfig {

    private final PokemonRepository pokemonRepository;

    @Bean 
    public CreatePokemonUseCase createPokemonUseCase(){
        return new CreatePokemonUseCase(pokemonRepository);
    }

    @Bean 
    public CreatePokemonService createPokemonService(){
        return new CreatePokemonService(createPokemonUseCase());
    }

    @Bean 
    public CreatePokemonUseCase createPokemonUseCase(){
        return new CreatePokemonUseCase();
    }

    @Bean 
    public CreatePokemonService createPokemonService(){
        return new CreatePokemonService(createPokemonUseCase());
    }

    @Bean 
    public FindPokemonUseCase findPokemonUseCase(){
        return new FindPokemonUseCase();
    }

    @Bean 
    public FindPokemonService findPokemonService(){
        return new FindPokemonService(findPokemonUseCase());
    }
    
}