package com.gestiondetareas.app.rest.services;

import com.gestiondetareas.app.rest.models.Tarea;

import java.util.List;

public interface TareaService {

    List<Tarea> listaDeTareas();

    Tarea buscarTareaPorId(Long id);

    Tarea guardarTarea(Tarea tareaNuevo);

    void borrarTarea(Long id);

    Tarea editarTareaPorId(Long id, Tarea tareaActualizado);
}
