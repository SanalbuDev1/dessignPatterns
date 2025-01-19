package patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transport;

import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.dto.Box;

public class Truck implements Transport {

    @Override
    public void deliver(Box box) {
        System.out.println("Delivering by truck: " + box);
    }
}
