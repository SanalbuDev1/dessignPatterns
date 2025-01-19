package patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.aplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.dto.Box;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transport.Transport;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transportStrategy.TransportBox;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transportStrategy.TransportStrategy;

import java.util.List;

@Configuration
public class ConfigBean {

    private final List<TransportStrategy> strategies;

    public ConfigBean(List<TransportStrategy> strategies) {
        this.strategies = strategies;
    }

    @Bean
    public TransportBox transportBox() {
        return new TransportBox(this::selectTransport);
    }

    private Transport selectTransport(Box box) {
        return strategies.stream()
                .filter(strategy -> strategy.supports(box))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No suitable transport found for box: " + box))
                .getTransport();
    }

}
