package pe.ineapp.ineapppersonaservice.Mundial.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Player")
@Table(
        name = "tbl_player",
        uniqueConstraints = {
                @UniqueConstraint(name = "player_id_unique", columnNames = "id")
        }
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )
    @Id
    Long id;
    String jugador;
    String pais;
    String edad;
}
