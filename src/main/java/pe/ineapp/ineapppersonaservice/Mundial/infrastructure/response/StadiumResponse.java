package pe.ineapp.ineapppersonaservice.Mundial.infrastructure.response;

import lombok.Builder;
import lombok.Data;
import pe.ineapp.ineapppersonaservice.Mundial.domain.entity.Stadium;

import java.util.List;

@Builder
@Data
public class StadiumResponse {
    private List<Stadium> stadiumList;
    private BasicResponse basicResponse;
}
