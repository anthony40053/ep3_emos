package pe.ineapp.ineapppersonaservice.Mundial.application.service;

import pe.ineapp.ineapppersonaservice.Mundial.infrastructure.request.PlayerRequest;
import pe.ineapp.ineapppersonaservice.Mundial.infrastructure.response.*;

public interface MundialService {
    public ApiResponse getApis();
    public CountryResponse getPaises();
    public PlayerResponse getJugadores();
    public StadiumResponse getEstadios();
    public BasicResponse addJugador(PlayerRequest request);
}
