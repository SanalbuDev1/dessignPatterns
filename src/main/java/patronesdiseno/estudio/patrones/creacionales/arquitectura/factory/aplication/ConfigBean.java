package patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.aplication;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.dto.Box;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.gateway.OperationDataBase;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transport.Transport;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transportStrategy.*;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.infraestructure.r2dbc.OracleDataBase;

import java.util.List;

@Configuration
public class ConfigBean {

    @Bean
    public TransportSelectionService transportSelectionService(List<TransportStrategy> strategies) {
        return new TransportSelectionService(strategies);
    }

    @Bean
    public OperationDataBase operationDataBase() {
        return new OracleDataBase();
    }

    @Bean
    public TransportBox transportBox(TransportSelectionService selectionService, OperationDataBase operationDataBase) {
        return new TransportBox(selectionService, operationDataBase);
    }

    @Bean
    public TransportStrategy getTransportAirplaneStrategy() {
        return new AirplaneStrategy();
    }

    @Bean
    public TransportStrategy getTransportShipStrategy() {
        return new ShipStrategy();
    }

    @Bean
    public TransportStrategy getTransportTruckStrategy() {
        return new TruckStrategy();
    }



}
