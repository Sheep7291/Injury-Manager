package Training.Plan.Injury.Manager.service;

import Training.Plan.Injury.Manager.repository.InjuryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InjuryService {

    private final InjuryRepository injuryRepository;
}
