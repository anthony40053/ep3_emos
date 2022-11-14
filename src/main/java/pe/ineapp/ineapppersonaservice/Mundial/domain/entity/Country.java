package pe.ineapp.ineapppersonaservice.Mundial.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Country")
@Table(
        name = "tbl_country",
        uniqueConstraints = {
                @UniqueConstraint(name = "contry_id_unique", columnNames = "id")
        }
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @SequenceGenerator(
            name = "country_sequence",
            sequenceName = "country_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "country_sequence"
    )
    @Id
    Long id;
    String pais;
    String continente;
    String grupo;
}
