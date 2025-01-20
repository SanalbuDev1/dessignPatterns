package patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transportStrategy;

import lombok.AllArgsConstructor;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.dto.Box;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transport.Transport;

import java.util.List;

// 1) Clase de dominio/aplicación (pseudocódigo)
@AllArgsConstructor
public class TransportSelectionService {

    private final List<TransportStrategy> strategies;

    public Transport selectTransport(Box box) {
        return strategies.stream()
                .filter(strategy -> strategy.supports(box))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No suitable transport found for box: " + box))
                .getTransport();
    }
}
