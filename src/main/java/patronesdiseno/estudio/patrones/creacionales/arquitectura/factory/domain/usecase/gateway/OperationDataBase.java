package patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.gateway;

import java.util.List;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.dto.Box;

public interface OperationDataBase {

    void save(Box box);
    List<Box> findAll();


}
