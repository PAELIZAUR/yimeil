package edu.unsada.yimeil.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
    @Id
    private Long id;
    private String nombre;

    // Getters y setters

    public Cliente() {}

    public Cliente(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y setters
}
