package com.tiendis.tiendis.entity;

import javax.persistence.*;

@Entity
@Table(name = "Departamento", schema= "public")
public class Departamento {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDep", length = 3, nullable = false, unique = true )
    private String id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;


    // *************** CONSTRUCTORES **********************
    public Departamento() {
    }

    public Departamento(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

// ************** GETTER AND SETTER *******************

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    // ************ ToString ***************************


    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
