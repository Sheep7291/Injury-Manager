package Training.Plan.Injury.Manager.service;

import Training.Plan.Injury.Manager.dto.InjuryDto;
import Training.Plan.Injury.Manager.entity.InjuryEntity;
import Training.Plan.Injury.Manager.repository.InjuryRepository;
import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class InjuryService {

    private final InjuryRepository injuryRepository;

    public List<InjuryDto> returnUserInjuries(String username) {
        List<InjuryEntity> injuryEntities = injuryRepository.findByUsername(username);
        List<InjuryDto> injuryDtoList = injuryEntities
                .stream()
                .map(injuryEntity -> InjuryDto.builder()
                        .username(injuryEntity.getUsername())
                        .nameOfInjury(injuryEntity.getNameOfInjury())
                        .timeWhenInjuryHappen(injuryEntity.getTimeWhenInjuryHappen())
                        .source(injuryEntity.getSource())
                        .build())
                .collect(Collectors.toList());

        return injuryDtoList;
    }

    public void saveInjury(InjuryDto injuryDto){
        InjuryEntity injuryEntity = InjuryEntity.builder()
                .username(injuryDto.getUsername())
                .nameOfInjury(injuryDto.getNameOfInjury())
                .timeWhenInjuryHappen(injuryDto.getTimeWhenInjuryHappen())
                .source(injuryDto.getSource())
                .build();
        injuryRepository.save(injuryEntity);
    }

    public List<InjuryDto> returnAllInjuries() {
        List<InjuryEntity> injuryEntities = injuryRepository.findAll();
        List<InjuryDto> injuryDtoList = injuryEntities
                .stream()
                .map(injuryEntity -> InjuryDto.builder()
                        .username(injuryEntity.getUsername())
                        .nameOfInjury(injuryEntity.getNameOfInjury())
                        .timeWhenInjuryHappen(injuryEntity.getTimeWhenInjuryHappen())
                        .source(injuryEntity.getSource())
                        .build())
                .collect(Collectors.toList());

        return injuryDtoList;
    }
}
