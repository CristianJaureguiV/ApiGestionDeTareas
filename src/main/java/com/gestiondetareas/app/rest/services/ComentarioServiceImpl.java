package com.gestiondetareas.app.rest.services;

import jakarta.transaction.Transactional;
import com.gestiondetareas.app.rest.models.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestiondetareas.app.rest.repositories.ComentarioRepository;

import java.util.List;

@Service// preguntar q hace esto
@Transactional// preguntar sobre esto
public class ComentarioServiceImpl implements ComentarioService{

    @Autowired
    ComentarioRepository comentarioRepository;
    @Override
    public List<Comentario> listaDeComentarios() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario buscarComentarioPorId(Long id) {
        Boolean existe = comentarioRepository.existsById(id);

        if (existe) {
            Comentario comentarioEscogida = comentarioRepository.findById(id).get();
            return comentarioEscogida;
        } else {
            System.out.println("El id es inválido o no existe");
            return null;
        }
    }

    @Override
    public Comentario guardarComentario(Comentario comentarioNuevo) {

        return comentarioRepository.save(comentarioNuevo);

    }

    @Override
    public void borrarComentario(Long id) {
        comentarioRepository.deleteById(id);

    }

    @Override
    public Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado) {
        Boolean existe = comentarioRepository.existsById(id);

        if (existe) {
            Comentario comentarioSeleccionado = comentarioRepository.findById(id).get();
            comentarioSeleccionado.setFechaDeCreacion(comentarioActualizado.getFechaDeCreacion());
            comentarioSeleccionado.setTexto(comentarioActualizado.getTexto());
            System.out.println("El comentario ha sido actualizado");
            return comentarioRepository.save(comentarioSeleccionado);
        } else {
            System.out.println("El comentario no existe o el id es inválido");
            return null;
        }
    }

}
