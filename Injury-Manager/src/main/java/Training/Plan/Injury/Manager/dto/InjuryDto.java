package Training.Plan.Injury.Manager.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class InjuryDto implements Serializable {
    private String username;
    private String nameOfInjury;
    private LocalDate timeWhenInjuryHappen;
    private String source;
}
