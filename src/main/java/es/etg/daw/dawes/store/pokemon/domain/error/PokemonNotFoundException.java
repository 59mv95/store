package es.etg.daw.dawes.store.pokemon.domain.error;

public class PokemonNotFoundException extends EntityNotFoundException{
    
    public static final String ENTIDAD = "pokemon";

    public PokemonNotFoundException(){
        super(ENTIDAD);
    }

    public PokemonNotFoundException(int id){
        super(ENTIDAD, id);
    }
}