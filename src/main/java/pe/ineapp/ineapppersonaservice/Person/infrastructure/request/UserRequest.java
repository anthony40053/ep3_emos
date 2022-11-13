package pe.ineapp.ineapppersonaservice.Person.infrastructure.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserRequest {
    private String name;
    private String lastName;
    private String dni;
    private String email;
    private LocalDate birthDate;
    private String password;
}
