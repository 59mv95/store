package es.etg.daw.dawes.store.pokemon.infraestructure.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.RECORD_COMPONENT })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NombradoPokemonValidator.class)
@Documented
public @interface NombradoPokemon {
    String message() default "{es.etg.daw.dawes.store.pokemon.infraestructure.web.validation.NombradoPokemon}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}