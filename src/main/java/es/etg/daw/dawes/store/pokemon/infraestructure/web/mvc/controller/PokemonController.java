
package es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import es.etg.daw.dawes.store.pokemon.application.command.CreatePokemonCommand;
import es.etg.daw.dawes.store.pokemon.application.command.EditPokemonCommand;
import es.etg.daw.dawes.store.pokemon.application.service.CreatePokemonService;
import es.etg.daw.dawes.store.pokemon.application.service.FindPokemonService;
import es.etg.daw.dawes.store.pokemon.application.service.EditPokemonService;
import es.etg.daw.dawes.store.pokemon.application.service.DeletePokemonService;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import es.etg.daw.dawes.store.pokemon.infraestructure.mapper.PokemonMapper;
import es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.dto.PokemonRequest;
import es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.dto.PokemonResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/pokemons")
@RequiredArgsConstructor
public class PokemonController {

    private final CreatePokemonService createPokemonService;
    private final FindPokemonService findPokemonService;
    private final EditPokemonService editPokemonService;
    private final DeletePokemonService deletePokemonService;

    private final PokemonMapper pokemonMapper;
    

    @PostMapping
    @ResponseBody
    public String createPokemon(PokemonRequest request) {


        CreatePokemonCommand comando =
                pokemonMapper.toCommand(request);

    }

    @GetMapping
    @ResponseBody
    public List<PokemonResponse> allPokemon() {

        return findPokemonService.findAll()
                .stream()
          .map(pokemonMapper::toResponse)
                .toList();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public PokemonResponse editPokemon(@PathVariable int id, @RequestBody PokemonRequest pokemonRequest) {

        EditPokemonCommand comando = pokemonMapper.toCommand(id, pokemonRequest);

        Pokemon pokemon = editPokemonService.update(comando);

        return pokemonMapper.toResponse(pokemon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable int id) {

        deletePokemonService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
