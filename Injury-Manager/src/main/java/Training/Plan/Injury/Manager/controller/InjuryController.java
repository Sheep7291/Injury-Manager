package Training.Plan.Injury.Manager.controller;

import Training.Plan.Injury.Manager.dto.InjuryDto;
import Training.Plan.Injury.Manager.service.InjuryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InjuryController {
    private final InjuryService injuryService;

    @GetMapping("/injuries")
    List<InjuryDto> getInjuriesByUsername(@RequestParam String username){
       return injuryService.returnUserInjuries(username);
    }
}
