package Com.Helpdesk.exeMesaDeAyuda.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "agente")
@Data
public class Agentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;
}
