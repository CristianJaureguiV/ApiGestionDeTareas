package com.gestiondetareas.app.rest.controllers;

import com.gestiondetareas.app.rest.models.Usuario;
import com.gestiondetareas.app.rest.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.EscapedErrors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/lista")
    public List<Usuario> listaUsuarios() {
        List<Usuario> listaMostrar = usuarioService.listaUsuarios();
        return listaMostrar;

    }

    //Buscar por id
    @GetMapping("/buscar/{id}")
    public Usuario usuarioPorId(@PathVariable Long id){
        Usuario usuarioMostrar = usuarioService.buscarUsuarioPorId(id);
        return usuarioMostrar;
    }

    //Crear nuevo usuario
    @PostMapping("/nuevo")
    public Usuario guardarNuevoUsuario(@RequestBody Usuario usuarioNuevo) {
        Usuario usuarioParaGuardar = usuarioService.guardarUsuario(usuarioNuevo);
        return usuarioParaGuardar;
    }

    //Para borrar
    @DeleteMapping("/borrar")
    public String borrarUsuarioPorId(@RequestParam Long id) {
        usuarioService.borrarUsuario(id);
        return "El estudiante ha sido borrado";
    }

    //Para editar
    @PutMapping("/editar/{id}")
    public Usuario editarUsuarioPorId(@PathVariable Long id,
                                      @RequestBody Usuario usuarioActualizado) {
        Usuario usuarioEditado = usuarioService.editarUsuarioPorId(id,
                usuarioActualizado);

        return usuarioEditado;
    }

}
