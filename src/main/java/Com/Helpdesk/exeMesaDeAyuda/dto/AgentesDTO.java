package Com.Helpdesk.exeMesaDeAyuda.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AgentesDTO {

    private Long idAgente;

    private String nombre;

    private String email;
}
