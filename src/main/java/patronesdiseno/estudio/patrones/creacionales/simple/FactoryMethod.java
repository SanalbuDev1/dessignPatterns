package patronesdiseno.estudio.patrones.creacionales.simple;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * La clase FactoryMethod es responsable de crear el método de transporte adecuado
 * según las características del pedido (peso, tamaño, urgencia, destino internacional o nacional, etc.).
 *
 * Métodos de transporte disponibles:
 * - Transporte Terrestre (camión o furgoneta)
 * - Transporte Aéreo (avión)
 * - Transporte Marítimo (barco)
 *
 * Ejemplos de uso:
 * - Si el paquete es urgente y ligero, podría enviarse por avión.
 * - Si el paquete es muy pesado, convendría enviarlo por barco (aunque tarde más).
 * - Si el destino está cerca y los tiempos de entrega no son tan estrictos, se envía por camión.
 *
 * La clase fábrica decide qué método de transporte es el adecuado sin que el resto del sistema
 * tenga que preocuparse por instanciar explícitamente las clases concretas.
 */

public class FactoryMethod {

    interface Transport {
        void deliver(Box box);
    }

    class TransportFactory  {

        /*Aqui se puede mejorar el codigo usando un strategy*/

        public Transport getTransport(Box box) {
            if (box.isUrgent && box.isInternational) {
                return new Airplane();
            } else if (box.weight > 100000) {
                return new Ship();
            } else if (box.size < 1000) {
                return new ElectricTruck();
            } else {
                return new Truck();
            }
        }
    }

    @AllArgsConstructor
    @ToString
    class Box {
        private double weight;
        private double size;
        private boolean isUrgent;
        private boolean isInternational;
    }

    class Truck implements Transport {
        @Override
        public void deliver(Box box) {
            System.out.println("Entregando por algun tipo de camion " + box);
        }
    }

    class ElectricTruck implements Transport {
        @Override
        public void deliver(Box box) {
            System.out.println("Entregando por camion electrico " + box);
        }
    }

    class Airplane implements Transport {
        @Override
        public void deliver(Box box) {
            System.out.println("Entregando por avión " + box);
        }
    }

    class Ship implements Transport {
        @Override
        public void deliver(Box box) {
            System.out.println("Entregando por barco " + box);
        }
    }

    public static void main(String[] args) {
        FactoryMethod factoryMethod = new FactoryMethod();
        TransportFactory fabricTransport = factoryMethod.new TransportFactory();

        Box box = factoryMethod.new Box(1000000, 1000, true, true);
        Box box2 = factoryMethod.new Box(1000, 100, false, false);
        Box box3 = factoryMethod.new Box(1000, 999, false, true);
        Box box4 = factoryMethod.new Box(100, 1001, false, false);
        List<Box> boxes = Arrays.asList(box, box2, box3,box4);

        boxes.stream().forEach(b -> {
            Transport transport = fabricTransport.getTransport(b);
            transport.deliver(b);
        });
    }

}
