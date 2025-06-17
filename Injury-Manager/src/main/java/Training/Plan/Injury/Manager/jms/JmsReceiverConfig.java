package Training.Plan.Injury.Manager.jms;

import Training.Plan.Injury.Manager.dto.InjuryDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JmsReceiverConfig {
    @Bean
    public ObjectMapper customObjectMapper() {
        return JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .build();
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(customObjectMapper());
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_asb_");

        Map<String, Class<?>> typeidMappings = new HashMap<>();
        typeidMappings.put("InjuryDto", InjuryDto.class);
        converter.setTypeIdMappings(typeidMappings);
        return converter;
    }
}
