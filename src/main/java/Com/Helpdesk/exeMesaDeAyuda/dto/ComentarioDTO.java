package Com.Helpdesk.exeMesaDeAyuda.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComentarioDTO {

    private Long idComentario;

    private Long idTicket;

    private Long idCategoria;

    private String mensaje;

    private String creadoEn;
}
