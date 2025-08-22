package Proyecto.SafePlay.controladores;

import org.springframework.web.bind.annotation.GetMapping;

public class UsuarioControlador {

    @GetMapping("/")
    public String mostrarPaginaPrincipal() {
        return "index"; // se busca en templates/index.html
    }
}
