package es.etg.daw.dawes.store.pokemon.infraestructure.web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NombradoPokemonValidator implements ConstraintValidator<NombradoPokemon, String>{

    public final static String STR_BLANCO = " ";
    public final static String STR_SALTO = "\n";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // El nombre no es nulo, ni vacío, ni tiene blancos ni saltos de línea
        if(value == null || value.length()==0 || value.contains(STR_BLANCO) || value.contains(STR_SALTO))
            return false;

        return true;
    }
}