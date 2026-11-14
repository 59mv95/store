package es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.HtmlUtils;

import es.etg.daw.dawes.store.pokemon.application.command.CreatePokemonCommand;
import es.etg.daw.dawes.store.pokemon.application.command.EditPokemonCommand;
import es.etg.daw.dawes.store.pokemon.application.service.CreatePokemonService;
import es.etg.daw.dawes.store.pokemon.application.service.DeletePokemonService;
import es.etg.daw.dawes.store.pokemon.application.service.EditPokemonService;
import es.etg.daw.dawes.store.pokemon.application.service.FindPokemonService;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import es.etg.daw.dawes.store.pokemon.infraestructure.mapper.PokemonMapper;
import es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.dto.PokemonRequest;
import es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.dto.PokemonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/pokemons")
@RequiredArgsConstructor
public class PokemonController {

    private final CreatePokemonService createPokemonService;
    private final FindPokemonService findPokemonService;
    private final EditPokemonService editPokemonService;
    private final DeletePokemonService deletePokemonService;

    // Mapper generado por MapStruct, lo inyecta Spring
    private final PokemonMapper pokemonMapper;

    @PostMapping
    @ResponseBody
    public String createPokemon(@Valid PokemonRequest request) {

        CreatePokemonCommand comando = pokemonMapper.toCommand(request);

        Pokemon pokemon = createPokemonService.createPokemon(comando);

        return """
            <!DOCTYPE html>
            <html lang="es">
              <head>
                <meta charset="UTF-8">
                <title>Pokemon</title>
              </head>
              <body>
                <h1>Pokemon: %s - %s</h1>
                <p>Tipo: %s</p>
                <p>Precio: %s</p>
                <p>Creado el: %s</p>
              </body>
            </html>
            """.formatted(
                pokemon.getId(),
                pokemon.getNombre(),
                pokemon.getTipo(),
                pokemon.getPrecio(),
                pokemon.getCreatedAt()
            );
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

    // Captura los errores de validación y devuelve un html con el listado de errores
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public String handleValidationExceptions(MethodArgumentNotValidException ex) {

        StringBuilder html = new StringBuilder(256);
        html.append("<!DOCTYPE html>")
            .append("<html lang=\"es\"><head><meta charset=\"UTF-8\">")
            .append("<title>Errores de validación</title></head><body>")
            .append("<h1>Errores de validación</h1>")
            .append("<ul>");

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field   = (error instanceof FieldError fe) ? fe.getField() : error.getObjectName();
            String message = error.getDefaultMessage();

            html.append("<li><strong>")
                .append(HtmlUtils.htmlEscape(field))
                .append("</strong>: ")
                .append(HtmlUtils.htmlEscape(message))
                .append("</li>");
        });

        html.append("</ul></body></html>");
        return html.toString();
    }
}