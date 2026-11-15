package es.etg.daw.dawes.store.pokemon.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.store.pokemon.application.service.CreatePokemonService;
import es.etg.daw.dawes.store.pokemon.application.service.DeletePokemonService;
import es.etg.daw.dawes.store.pokemon.application.service.EditPokemonService;
import es.etg.daw.dawes.store.pokemon.application.service.FindPokemonService;
import es.etg.daw.dawes.store.pokemon.application.usecase.CreatePokemonUseCase;
import es.etg.daw.dawes.store.pokemon.application.usecase.DeletePokemonUseCase;
import es.etg.daw.dawes.store.pokemon.application.usecase.EditPokemonUseCase;
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
    public FindPokemonUseCase findPokemonUseCase(){
        return new FindPokemonUseCase(pokemonRepository);
    }

    @Bean 
    public FindPokemonService findPokemonService(){
        return new FindPokemonService(findPokemonUseCase());
    }

    @Bean 
    public EditPokemonUseCase editPokemonUseCase(){
        return new EditPokemonUseCase(pokemonRepository);
    }

    @Bean 
    public EditPokemonService editPokemonService(){
        return new EditPokemonService(editPokemonUseCase());
    }

    @Bean 
    public DeletePokemonUseCase deletePokemonUseCase(){
        return new DeletePokemonUseCase(pokemonRepository);
    }

    @Bean 
    public DeletePokemonService deletePokemonService(){
        return new DeletePokemonService(deletePokemonUseCase());
    }
    
}