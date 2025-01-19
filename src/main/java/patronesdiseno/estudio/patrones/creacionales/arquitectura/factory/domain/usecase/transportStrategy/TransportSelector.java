package patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transportStrategy;

import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.dto.Box;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transport.Transport;

@FunctionalInterface
public interface TransportSelector {

    Transport selectTransport(Box box);

}
