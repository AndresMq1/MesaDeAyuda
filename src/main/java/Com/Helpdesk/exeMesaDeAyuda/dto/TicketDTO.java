package Com.Helpdesk.exeMesaDeAyuda.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketDTO {

    private Long idTicket;

    private Long idUsuario;

    private Long idCategoria;

    private String titulo;

    private String descripcion;

    private String prioridad;

    private String estado;

    private LocalDateTime creadoEn;
}
