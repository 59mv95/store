package es.etg.daw.dawes.store.pokemon.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.store.pokemon.application.service.CreatePokemonService;
import es.etg.daw.dawes.store.pokemon.application.usecase.CreatePokemonUseCase;
import lombok.RequiredArgsConstructor;

@Configuration 
@RequiredArgsConstructor 
public class PokemonConfig {

    @Bean 
    public CreatePokemonUseCase createPokemonUseCase(){
        return new CreatePokemonUseCase();
    }

    @Bean 
    public CreatePokemonService createPokemonService(){
        return new CreatePokemonService(createPokemonUseCase());
    }
    
}