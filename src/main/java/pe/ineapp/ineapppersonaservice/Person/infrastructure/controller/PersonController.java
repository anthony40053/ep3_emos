package pe.ineapp.ineapppersonaservice.Person.infrastructure.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.ineapp.ineapppersonaservice.Person.domain.entity.Person;
import pe.ineapp.ineapppersonaservice.Person.application.service.PersonService;
import pe.ineapp.ineapppersonaservice.Person.infrastructure.request.UserRequest;
import pe.ineapp.ineapppersonaservice.Person.infrastructure.response.BasicResponse;
import pe.ineapp.ineapppersonaservice.Person.infrastructure.response.UserResponse;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;


    //GET
    @GetMapping
    @RequestMapping("/getAll")
    public ResponseEntity<UserResponse> getAll() {
        UserResponse response = personService.getAll();
        return ResponseEntity.status(response.getBasicResponse().getCode()).body(response);
    }

    @GetMapping
    @RequestMapping("/getByDni")
    public ResponseEntity<UserResponse> getByDni(@RequestParam String dni) {
        UserResponse response = personService.getByDni(dni);
        return ResponseEntity.status(response.getBasicResponse().getCode()).body(response);
    }


    //POST
    @PostMapping
    @RequestMapping("/addUser")
    public ResponseEntity<BasicResponse> addUser(@RequestBody UserRequest request) {
        BasicResponse response = personService.addUser(request);
        return ResponseEntity.status(response.getCode()).body(response);
    }


    //PUT
    @PutMapping
    @RequestMapping("/updateUser")
    public ResponseEntity<BasicResponse> updateUser(@RequestBody UserRequest request,
                                                    @RequestParam String dni) {
        BasicResponse response = personService.updateUser(request, dni);
        return ResponseEntity.status(response.getCode()).body(response);
    }


    //DELETE
    @DeleteMapping
    @RequestMapping("/deleteUser")
    public ResponseEntity<BasicResponse> deleteUser(@RequestParam String dni) {
        BasicResponse response = personService.deleteUser(dni);
        return ResponseEntity.status(response.getCode()).body(response);
    }
}
