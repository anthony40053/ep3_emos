package pe.ineapp.ineapppersonaservice.Mundial.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.ineapp.ineapppersonaservice.Mundial.domain.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
