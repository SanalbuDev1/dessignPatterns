package patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transportStrategy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.dto.Box;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.gateway.OperationDataBase;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transport.Transport;

@AllArgsConstructor
public class TransportBox {

    private final TransportSelectionService transportSelector;
    private final OperationDataBase operationDataBase;

    public void startProcess(Box box) {
        deliver(box);
        operationDataBase.save(box);
    }

    public void deliver(Box box) {
        Transport transport = transportSelector.selectTransport(box);
        transport.deliver(box);

    }


}
