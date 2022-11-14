package pe.ineapp.ineapppersonaservice.Mundial.infrastructure.response;

import lombok.Builder;
import lombok.Data;
import pe.ineapp.ineapppersonaservice.Mundial.domain.entity.Country;

import java.util.List;

@Builder
@Data
public class CountryResponse {
    private List<Country> countryList;
    private BasicResponse basicResponse;
}
