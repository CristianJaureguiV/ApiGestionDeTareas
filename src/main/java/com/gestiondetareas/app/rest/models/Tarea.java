package com.gestiondetareas.app.rest.models;

import com.gestiondetareas.app.rest.services.ComentarioService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tareas")
@NoArgsConstructor//Nos va a crear el constructor vacío
@AllArgsConstructor//Genera constructor con todos los atributos
@Getter
@Setter

public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tareaId;

    private String titulo;

    private String descripcion;

    private Long fechaDeVencimiento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL)
    private List<Comentario> comentariosTarea;


}
