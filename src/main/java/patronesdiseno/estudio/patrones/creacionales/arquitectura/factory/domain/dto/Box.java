package patronesdiseno.estudio.patrones.creacionales.arquitectura.factory.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Box {
    private double weight;
    private double size;
    private boolean urgent;
    private boolean international;

}
