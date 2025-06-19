package Training.Plan.Injury.Manager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InjuryDto implements Serializable {
    private String username;
    private String nameOfInjury;
    private LocalDate timeWhenInjuryHappen;
    private String source;
    private String injuryDetails;
}
