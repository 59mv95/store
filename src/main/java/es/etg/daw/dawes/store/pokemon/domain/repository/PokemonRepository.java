package es.etg.daw.dawes.store.pokemon.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;

public interface PokemonRepository extends CRUDRepository<Pokemon, Integer>{
    public Optional<Pokemon> getByName(String name);
}