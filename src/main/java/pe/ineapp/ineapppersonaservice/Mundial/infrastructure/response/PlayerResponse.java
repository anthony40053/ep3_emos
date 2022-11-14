package pe.ineapp.ineapppersonaservice.Mundial.infrastructure.response;

import lombok.Builder;
import lombok.Data;
import pe.ineapp.ineapppersonaservice.Mundial.domain.entity.Player;

import java.util.List;

@Builder
@Data
public class PlayerResponse {
    private List<Player> playerList;
    private BasicResponse basicResponse;
}
