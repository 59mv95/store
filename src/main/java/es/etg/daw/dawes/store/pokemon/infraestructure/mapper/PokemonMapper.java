package es.etg.daw.dawes.store.pokemon.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.etg.daw.dawes.store.pokemon.application.command.CreatePokemonCommand;
import es.etg.daw.dawes.store.pokemon.application.command.EditPokemonCommand;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.dto.PokemonRequest;
import es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.dto.PokemonResponse;

//MapStruct registra PokemonMapperImpl como Bean de Spring, para que lo inyectes con @Autowired o por constructor.
@Mapper(componentModel = "spring")
public interface PokemonMapper {
    

    // Request -> Command (create). Los atributos se llaman igual hace un automapeo.
    CreatePokemonCommand toCommand(PokemonRequest request);


    // Domain -> Response. Los atributos se llaman ingual entre origen y destino. automapeo.
    PokemonResponse toResponse(Pokemon pokemon);


    // Request + id -> Command (edit)
    //  Como tenemos dos fuentes distintas, tenemos que decirle como hacer el mapeo
    @Mapping(source = "id", target = "id")
    @Mapping(source = "request.foto", target = "foto")
    @Mapping(source = "request.precio", target = "precio")
    EditPokemonCommand toCommand(int id, PokemonRequest request);
}