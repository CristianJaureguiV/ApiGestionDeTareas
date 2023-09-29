package com.gestiondetareas.app.rest.controllers;

import com.gestiondetareas.app.rest.models.Comentario;
import com.gestiondetareas.app.rest.services.ComentarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")

public class ComentarioRestController {
    @Autowired
    ComentarioServiceImpl comentarioService;

    @GetMapping("/lista")
    public List<Comentario> listadeComentarios() {
        List<Comentario> listaMostrar = comentarioService.listaDeComentarios();
        return listaMostrar;
    }

    @GetMapping("/buscar/{id}")
    public Comentario ComentarioPorId(@PathVariable Long id) {
        Comentario comentarioMostrar = comentarioService.buscarComentarioPorId(id);
        return comentarioMostrar;
    }

    @PostMapping("/nuevo")
    public Comentario guardarNuevoComentario(@RequestBody Comentario comentarioNuevo) {
        Comentario comentarioParaGuardar = comentarioService.guardarComentario(comentarioNuevo);
        return comentarioParaGuardar;
    }

    //Para borrar
    @DeleteMapping("/borrar")
    public String borrarComentarioPorId(@RequestParam Long id) {
        comentarioService.borrarComentario(id);
        return "El comentario ha sido borrado";
    }

    //Para editar
    @PutMapping("/editar/{id}")
    public Comentario editarComentarioPorId(@PathVariable Long id,
                                            @RequestBody Comentario comentarioActualizado) {
        Comentario comentarioEditado = comentarioService.editarComentarioPorId(id,
                comentarioActualizado);

        return comentarioEditado;

    }
}
