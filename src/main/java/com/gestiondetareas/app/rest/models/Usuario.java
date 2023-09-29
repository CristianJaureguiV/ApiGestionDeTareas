package com.gestiondetareas.app.rest.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor//Nos va a crear el constructor vacío
@AllArgsConstructor//Genera constructor con todos los atributos
@Getter
@Setter

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(name = "nombre")
    @NotNull
    private String nombre;

    @Email(message = "Introdujiste un mail erróneo")
    @NotNull
    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Tarea> tareasUsuario;

}
