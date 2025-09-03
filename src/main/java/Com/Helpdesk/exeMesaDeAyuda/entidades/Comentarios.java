package Com.Helpdesk.exeMesaDeAyuda.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
@Data
public class Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;

    //aca esta el ID_ticket
    @ManyToOne
    @JoinColumn(name = "IdTicket")
    private Ticket ticket;

    // aca esta el Id_agente
    @ManyToOne
    @JoinColumn(name = "IdCategoria")
    private  Categorias categoria;

    @Column(name = "mensaje", nullable = false, length = 255)
    private String mensaje;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn;

}
