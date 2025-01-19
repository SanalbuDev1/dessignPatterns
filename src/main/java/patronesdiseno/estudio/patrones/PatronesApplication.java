package patronesdiseno.estudio.patrones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.infraestructure.TransportQueue;

@SpringBootApplication
public class PatronesApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PatronesApplication.class, args);
	}

}
