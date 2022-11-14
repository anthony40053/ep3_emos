package pe.ineapp.ineapppersonaservice.Mundial.infrastructure.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerRequest {
    private String jugador;
    private String pais;
    private String edad;
}
