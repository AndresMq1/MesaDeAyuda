package Com.Helpdesk.exeMesaDeAyuda.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketDTO {

    private Long idTicket;

    private Long idUsuario;

    private Long idCategoria;

    private String nombre;

    private String email;
}
