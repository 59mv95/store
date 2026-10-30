package es.etg.daw.dawes.store.pokemon.application.usecase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import es.etg.daw.dawes.store.pokemon.domain.repository.PokemonRepository;
import es.etg.daw.dawes.store.pokemon.domain.error.PokemonNotFoundException;

public class FindPokemonUseCase {

    public PokemonRepository pokemonRepository;

    public List<Pokemon> findAll(){

        List<Pokemon> pokemons = pokemonRepository.getAll();

        if (pokemons.isEmpty())
            throw new PokemonNotFoundException();

        return pokemonRepository.getAll();

    }
}