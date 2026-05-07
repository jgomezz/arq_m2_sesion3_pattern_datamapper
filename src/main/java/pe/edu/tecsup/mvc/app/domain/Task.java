package pe.edu.tecsup.mvc.app.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Task {
    private Long id;
    private String titulo;
    private boolean completada;

}
