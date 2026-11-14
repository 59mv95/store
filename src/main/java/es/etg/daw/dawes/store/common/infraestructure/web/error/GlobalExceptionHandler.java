package es.etg.daw.dawes.store.common.infraestructure.web.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import es.etg.daw.dawes.store.pokemon.domain.error.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Excepciones de tipo NullPointer de toda la aplicación -> 500
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> nullPointerHandler(NullPointerException npe) {
        CustomResponse cr = new CustomResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, npe.getMessage());
        return buildResponse(cr);
    }

    // Entidades no encontradas (PokemonNotFoundException hereda de ésta) -> 404
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundHandler(EntityNotFoundException enfe) {
        CustomResponse cr = new CustomResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND, enfe.getMessage());
        return buildResponse(cr);
    }

    private ResponseEntity<String> buildResponse(CustomResponse cr) {
        return ResponseEntity
                .status(cr.getStatus())
                .contentType(MediaType.TEXT_HTML) // Para que el navegador sepa que la respuesta es html
                .body(buildErrorHtml(cr));
    }

    private String buildErrorHtml(CustomResponse cr) {
        return """
                <!DOCTYPE html>
                <html lang="es">
                <head>
                    <meta charset="UTF-8">
                    <title>Error</title>
                </head>
                <body>
                    <div class="card">
                        <h1>Se ha producido un error</h1>
                        <dl>
                            <dt>Fecha</dt>   <dd>%s</dd>
                            <dt>Código</dt>  <dd>%s - %s</dd>
                            <dt>Mensaje</dt> <dd>%s</dd>
                        </dl>
                    </div>
                </body>
                </html>
                """.formatted(
                        escapeHtml(String.valueOf(cr.getDate())),
                        cr.getStatus().value(),
                        escapeHtml(cr.getStatus().getReasonPhrase()),
                        escapeHtml(cr.getMessage()));
    }

    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}