package pe.ineapp.ineapppersonaservice.Mundial.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.ineapp.ineapppersonaservice.Mundial.application.service.MundialService;
import pe.ineapp.ineapppersonaservice.Mundial.infrastructure.request.PlayerRequest;
import pe.ineapp.ineapppersonaservice.Mundial.infrastructure.response.*;

@RestController
@RequestMapping("api/v1/mundial")
public class MundialController {
    @Autowired
    private MundialService mundialService;

    //Listado de APIs
    @GetMapping
    @RequestMapping("")
    public ResponseEntity<ApiResponse> getApis() {
        ApiResponse response = mundialService.getApis();
        return ResponseEntity.status(response.getBasicResponse().getCode()).body(response);
    }

    //Listado de países
    @GetMapping
    @RequestMapping("/paises")
    public ResponseEntity<CountryResponse> getPaises() {
        CountryResponse response = mundialService.getPaises();
        return ResponseEntity.status(response.getBasicResponse().getCode()).body(response);
    }

    //Listado de jugadores
    @GetMapping
    @RequestMapping("/jugadores")
    public ResponseEntity<PlayerResponse> getJugadores() {
        PlayerResponse response = mundialService.getJugadores();
        return ResponseEntity.status(response.getBasicResponse().getCode()).body(response);
    }

    //Listado de estadios
    @GetMapping
    @RequestMapping("/estadios")
    public ResponseEntity<StadiumResponse> getEstadios() {
        StadiumResponse response = mundialService.getEstadios();
        return ResponseEntity.status(response.getBasicResponse().getCode()).body(response);
    }

    //Registrar nuevo jugador
    @PostMapping
    @RequestMapping("/jugadores/add")
    public ResponseEntity<BasicResponse> addJugador(@RequestBody PlayerRequest request) {
        BasicResponse response = mundialService.addJugador(request);
        return ResponseEntity.status(response.getCode()).body(response);
    }
}
