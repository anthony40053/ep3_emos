package pe.ineapp.ineapppersonaservice.Mundial.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Stadium")
@Table(
        name = "tbl_stadium",
        uniqueConstraints = {
                @UniqueConstraint(name = "stadium_id_unique", columnNames = "id")
        }
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stadium {
    @SequenceGenerator(
            name = "stadium_sequence",
            sequenceName = "stadium_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stadium_sequence"
    )
    @Id
    Long id;
    String estadio;
    String ciudad;
}
