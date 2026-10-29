package es.etg.daw.dawes.store.pokemon.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import es.etg.daw.dawes.store.pokemon.domain.repository.PokemonRepository;


@Repository 
public class PokemonRepositoryMockImpl implements PokemonRepository{

    private final Map<Integer, Pokemon> pokemons = PokemonFactory.getDemoData();

    @Override
    public Pokemon save(Pokemon t) {
        if(t.getId()==0)
            t.setId(obtenerSiguienteId());
        pokemons.put(t.getId(), t);

        return t;
    }

    private int obtenerSiguienteId(){
        int ultimo = 0;
        if(!pokemons.isEmpty()){
            Collection<Pokemon> lista = pokemons.values();
            
            for (Pokemon p : lista) {
                ultimo = p.getId();
            }

        }
        return ultimo+1;
    }

    @Override
    public List<Pokemon> getAll() {
        return new ArrayList<>(pokemons.values());
    }

    @Override
    public Optional<Pokemon> getById(Integer id) {
        return Optional.ofNullable(pokemons.get(id));
    }

    @Override
    public void deteteById(Integer id) {
        pokemons.remove(id);
    }

    @Override
    public Optional<Pokemon> getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }
    
}