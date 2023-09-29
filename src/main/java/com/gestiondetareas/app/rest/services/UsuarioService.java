package com.gestiondetareas.app.rest.services;

import com.gestiondetareas.app.rest.models.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listaUsuarios();

    Usuario buscarUsuarioPorId(Long id);

    Usuario guardarUsuario(Usuario usuarioNuevo);

    void borrarUsuario(Long id);

    Usuario editarUsuarioPorId(Long ID, Usuario usuarioActualizado);

}
