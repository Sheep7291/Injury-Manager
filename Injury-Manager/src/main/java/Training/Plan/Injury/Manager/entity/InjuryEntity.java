package Training.Plan.Injury.Manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class InjuryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    private String username;
    private String nameOfInjury;
    private LocalDate timeWhenInjuryHappen;
    private String source;
    private String injuryDetails;
}
