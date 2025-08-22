package Proyecto.SafePlay.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremental en PostgreSQL
    @Column(name = "id")
    private Long id;

    @Column(name = "usu_usuario", nullable = false, unique = true)
    private String usuario; // será el "username" para login

    @Column(name = "usu_contrasena", nullable = false)
    private String contrasena;

    @Column(name = "usu_nombre", nullable = false)
    private String nombre;

    @Column(name = "usu_cedula", nullable = false, unique = true)
    private Long cedula;

    @Column(name = "usu_telefono", nullable = false)
    private Long telefono;

    @Enumerated(EnumType.STRING)
    @Column(name = "usu_rol", nullable = false)
    private Rol rol;  // JUGADOR o SUPERVISOR
}