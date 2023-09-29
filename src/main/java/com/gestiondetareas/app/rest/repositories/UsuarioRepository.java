package com.gestiondetareas.app.rest.repositories;

import com.gestiondetareas.app.rest.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

}
