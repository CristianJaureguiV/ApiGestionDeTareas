package com.gestiondetareas.app.rest.services;

import com.gestiondetareas.app.rest.models.Usuario;
import com.gestiondetareas.app.rest.repositories.TareaRepository;
import com.gestiondetareas.app.rest.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TareaRepository tareaRepository;

    //Método para traer una lista de todos los registros
    @Override
    public List<Usuario> listaUsuarios() {return usuarioRepository.findAll();}

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        Boolean existe = usuarioRepository.existsById(id);
        if (existe) {
            Usuario usuarioEscogido = usuarioRepository.findById(id).get();
            return usuarioEscogido;

        } else {
            System.out.println("El id es inválido o no existe");
            return null;
        }

    }

    @Override
    public Usuario guardarUsuario(Usuario usuarioNuevo){
        return usuarioRepository.save(usuarioNuevo);
    }

    @Override
    public void borrarUsuario(Long id) {usuarioRepository.deleteById(id);}

    @Override
    public Usuario editarUsuarioPorId(Long id, Usuario usuarioActualizado) {
        Boolean existe = usuarioRepository.existsById(id);
        if (existe) {
            Usuario usuarioSeleccionado = usuarioRepository.findById(id).get();
            usuarioSeleccionado.setNombre(usuarioActualizado.getNombre());
            usuarioSeleccionado.setEmail(usuarioActualizado.getEmail());
            System.out.println("El usuario ha sido actualizado");
            return usuarioRepository.save(usuarioSeleccionado);
        } else {
            System.out.println("El usuario no existe o el id es inválido");
            return null;
        }
    }
}
