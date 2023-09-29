package com.gestiondetareas.app.rest.repositories;

import com.gestiondetareas.app.rest.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
