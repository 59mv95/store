package es.etg.daw.dawes.store.pokemon.application.usecase;

import es.etg.daw.dawes.store.pokemon.application.command.EditPokemonCommand;
import es.etg.daw.dawes.store.pokemon.domain.error.PokemonNotFoundException;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import es.etg.daw.dawes.store.pokemon.domain.repository.PokemonRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditPokemonUseCase {

    public PokemonRepository pokemonRepository;

    public Pokemon update(EditPokemonCommand comando){

        Pokemon pokemon = pokemonRepository.getById(comando.id())
                                           .orElseThrow(() -> new PokemonNotFoundException(comando.id()));

        pokemon.setFoto(comando.foto());
        pokemon.setPrecio(comando.precio());

        return pokemonRepository.save(pokemon);
    }
}