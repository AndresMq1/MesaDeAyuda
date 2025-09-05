package Com.Helpdesk.exeMesaDeAyuda.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuariosDTO {

    private Long idUsuario;

    private String nombre;

    private String email;

    private String password;

    private String rol;
}
