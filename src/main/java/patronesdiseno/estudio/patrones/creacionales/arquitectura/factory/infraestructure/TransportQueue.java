package patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.infraestructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.transportStrategy.TransportBox;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.dto.Box;

import java.util.logging.Logger;

@Component
public class TransportQueue implements CommandLineRunner {

    @Autowired
    private TransportBox transportBox;

    Logger logger = Logger.getLogger(TransportQueue.class.getName());

    @Override
    public void run(String... args) throws Exception {

        String json = "{\"weight\": 5, \"size\": 10, \"urgent\": true, \"international\": false}";
        String json2 = "{\"weight\": 150, \"size\": 50, \"urgent\": false, \"international\": true}";
        String json3 = "{\"weight\": 1001, \"size\": 30, \"urgent\": false, \"international\": false}";

        logger.info("Transporting boxes...");
        logger.info(String.format("Box 1: %s", json));
        logger.info(String.format("Box 2: %s", json2));
        logger.info(String.format("Box 3: %s", json3));

        ObjectMapper objectMapper = new ObjectMapper();
        Box box = objectMapper.readValue(json, Box.class);
        Box box2 = objectMapper.readValue(json2, Box.class);
        Box box3 = objectMapper.readValue(json3, Box.class);

        transportBox.deliver(box);
        transportBox.deliver(box2);
        transportBox.deliver(box3);
    }
}
