package patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transportStrategy;


import org.springframework.stereotype.Component;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.dto.Box;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transport.Airplane;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transport.Transport;

@Component
public class AirplaneStrategy implements TransportStrategy {

    @Override
    public boolean supports(Box box) {
        return box.isUrgent() && box.getWeight() < 1000;
    }

    @Override
    public Transport getTransport() {
        return new Airplane();
    }
}