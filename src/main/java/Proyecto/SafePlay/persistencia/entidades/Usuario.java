package Proyecto.SafePlay.persistencia.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
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

    // 🔹 Constructor vacío
    public Usuario() {}

    // 🔹 Constructor completo
    public Usuario(Long id, String usuario, String contrasena, String nombre, Long cedula, Long telefono, Rol rol) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.rol = rol;
    }

    // ---------- GETTERS Y SETTERS MANUALES ----------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}