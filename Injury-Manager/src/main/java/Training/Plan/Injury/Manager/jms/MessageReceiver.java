package Training.Plan.Injury.Manager.jms;

import Training.Plan.Injury.Manager.dto.InjuryDto;
import Training.Plan.Injury.Manager.service.InjuryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class MessageReceiver {
    private final InjuryService injuryService;

    @JmsListener(destination = "DLQ")
    public void dlqMessage(InjuryDto injuryDto){
        injuryService.saveInjury(injuryDto);
    }
}
