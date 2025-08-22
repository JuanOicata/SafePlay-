package Proyecto.SafePlay.servicios;

import Proyecto.SafePlay.persistencia.entidades.Usuario;
import Proyecto.SafePlay.persistencia.repositorio.UsuarioRepositorio;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioServicio implements UserDetailsService {

    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicio(UsuarioRepositorio usuarioRepository) {
        this.usuarioRepositorio = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(usuario.getUsuario())
                .password(usuario.getContrasena())
                .roles(usuario.getRol().name()) // JUGADOR o SUPERVISOR
                .build();
    }
}