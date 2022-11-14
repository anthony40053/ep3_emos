package pe.ineapp.ineapppersonaservice.Mundial.infrastructure.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiResponse {
    private String apiCountries;
    private String apiPlayers;
    private String apiStadiums;
    private BasicResponse basicResponse;
}
