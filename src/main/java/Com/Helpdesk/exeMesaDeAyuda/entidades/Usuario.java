package Com.Helpdesk.exeMesaDeAyuda.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nombre", nullable = false , length = 100)
    private String nombre;

    @Column(name = "email", nullable = false)
    private String email;

    private String password;

    private String rol;

    @OneToMany(mappedBy = "usuario")
    private List<Ticket> tickets;

}
