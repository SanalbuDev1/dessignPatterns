package patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.infraestructure.r2dbc;

import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.usecase.gateway.OperationDataBase;
import java.util.ArrayList;
import java.util.List;
import patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.dto.Box;

public class OracleDataBase implements OperationDataBase {

    @Override
    public void save(Box box) {
        System.out.println("Saving in Oracle: " + box);
    }

    @Override
    public List<Box> findAll() {
        System.out.println("Finding all in Oracle");
        return new ArrayList<>();
    }

}
