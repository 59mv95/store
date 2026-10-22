package es.etg.daw.dawes.store.pokemon.application.usecase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;

public class FindPokemonUseCase {


    public List<Pokemon> findAll(){

        //TODO Habría que implementarlo con un acceso real a los datos. 
        // lo vamos a simular
        List<Pokemon> lista = new ArrayList<>();
        lista.add(new Pokemon(1, "Pokemon1","tipo1","1", 1, LocalDateTime.now()));
        lista.add(new Pokemon(2, "Pokemon2","tipo2","2", 2, LocalDateTime.now()));
        lista.add(new Pokemon(2, "Pokemon3","tipo3","3", 3, LocalDateTime.now()));

        return lista;

    }
}