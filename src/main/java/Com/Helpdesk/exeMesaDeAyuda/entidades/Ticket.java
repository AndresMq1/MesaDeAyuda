package Com.Helpdesk.exeMesaDeAyuda.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;

    //Acaba la decla el id_usuario
    @ManyToOne
    @JoinColumn(name = "IdUsuario", nullable = false)
    private Usuario usuario;

    //lo ponemos para saber quien crea el ticke
    @ManyToOne
    @JoinColumn(name = "IdAgenteAsignado")
    private Usuario agenteAsignado;


    //Aca declaramos el id_categotia
    @ManyToOne
    @JoinColumn(name = "IdCategoria",nullable = false)
    private Categoria categoria;

    @Column(name = "titulo", nullable = false,length = 100)
    private String titulo;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "prioridad", nullable = false)
    private String prioridad; //ALTA ,BAJA ,MEDIA

    @Column(name = "estado")
    private String estado;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn;

}
