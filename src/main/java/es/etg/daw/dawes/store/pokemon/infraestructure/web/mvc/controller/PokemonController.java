package es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.etg.daw.dawes.store.pokemon.application.command.CreatePokemonCommand;
import es.etg.daw.dawes.store.pokemon.application.service.CreatePokemonService;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import es.etg.daw.dawes.store.pokemon.infraestructure.mapper.PokemonMapper;
import es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.dto.PokemonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller 
@RequestMapping ("/pokemons") //URL será /pokemons
@RequiredArgsConstructor 

public class PokemonController {

    private final CreatePokemonService createPokemonService;

    @PostMapping
    @ResponseBody
    public String createPokemon(PokemonRequest request) {
        CreatePokemonCommand commando = PokemonMapper.toCommand(request);

        Pokemon pokemon = createPokemonService.createPokemon(commando);
        
        return """
            <!DOCTYPE html>
            <html lang="es">
              <head>
                <meta charset="UTF-8">
                <title>Producto</title>
              </head>
              <body>
                <h1>Pokemon: %s - %s</h1>
                <p>Tipo: %s </p>
                <p>Precio: %s </p>
                <p>Creado el: %s </p>
              </body>
            </html>
            """.formatted(pokemon.getId(), pokemon.getNombre(), pokemon.getTipo(), pokemon.getPrecio(), pokemon.getCreatedAt());
    }
    
}