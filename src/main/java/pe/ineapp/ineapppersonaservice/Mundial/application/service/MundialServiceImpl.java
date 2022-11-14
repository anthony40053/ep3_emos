package pe.ineapp.ineapppersonaservice.Mundial.application.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.ineapp.ineapppersonaservice.Mundial.domain.entity.Country;
import pe.ineapp.ineapppersonaservice.Mundial.domain.entity.Player;
import pe.ineapp.ineapppersonaservice.Mundial.domain.entity.Stadium;
import pe.ineapp.ineapppersonaservice.Mundial.infrastructure.repository.CountryRepository;
import pe.ineapp.ineapppersonaservice.Mundial.infrastructure.repository.PlayerRepository;
import pe.ineapp.ineapppersonaservice.Mundial.infrastructure.repository.StadiumRepository;
import pe.ineapp.ineapppersonaservice.Mundial.infrastructure.request.PlayerRequest;
import pe.ineapp.ineapppersonaservice.Mundial.infrastructure.response.*;

import java.util.List;

@Log4j2
@Service
public class MundialServiceImpl implements MundialService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private StadiumRepository stadiumRepository;


    @Override
    public ApiResponse getApis() {
        return ApiResponse.builder()
                .apiCountries("http://localhost:8080/api/v1/mundial/paises")
                .apiPlayers("http://localhost:8080/api/v1/mundial/jugadores")
                .apiStadiums("http://localhost:8080/api/v1/mundial/estadios")
                .basicResponse(BasicResponse.whenSuccess())
                .build();
    }

    @Override
    public CountryResponse getPaises() {
        List<Country> countryList = countryRepository.findAll();

        if(countryList.isEmpty()) {
            return CountryResponse.builder()
                    .countryList(null)
                    .basicResponse(BasicResponse.whenNoDataFound("countries"))
                    .build();
        }

        return CountryResponse.builder()
                .countryList(countryList)
                .basicResponse(BasicResponse.whenSuccess())
                .build();
    }

    @Override
    public PlayerResponse getJugadores() {
        List<Player> playerList = playerRepository.findAll();

        if(playerList.isEmpty()) {
            return PlayerResponse.builder()
                    .playerList(null)
                    .basicResponse(BasicResponse.whenNoDataFound("players"))
                    .build();
        }

        return PlayerResponse.builder()
                .playerList(playerList)
                .basicResponse(BasicResponse.whenSuccess())
                .build();
    }

    @Override
    public StadiumResponse getEstadios() {
        List<Stadium> stadiumList = stadiumRepository.findAll();

        if(stadiumList.isEmpty()) {
            return StadiumResponse.builder()
                    .stadiumList(null)
                    .basicResponse(BasicResponse.whenNoDataFound("stadiums"))
                    .build();
        }

        return StadiumResponse.builder()
                .stadiumList(stadiumList)
                .basicResponse(BasicResponse.whenSuccess())
                .build();
    }

    @Override
    public BasicResponse addJugador(PlayerRequest request) {
        try {
            playerRepository.save(this.builderPlayerFromRequest(request));
            return BasicResponse.whenSuccess();
        }
        catch (Exception e) {
            log.error(e.getMessage());
            return BasicResponse.whenError(e.getMessage());
        }
    }

    //Builder de entidad 'Jugador'
    public Player builderPlayerFromRequest(PlayerRequest request) {
        return Player.builder()
                .jugador(request.getJugador())
                .pais(request.getPais())
                .edad(request.getEdad())
                .build();
    }
}
