package com.tiendis.tiendis.entity;

import javax.persistence.*;

@Entity
@Table(name = "Ciudad", schema= "public")
public class Ciudad {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCiudad", length = 5, nullable = false, unique = true )
    private String id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "IdDepartamento")
    private Departamento departamento;


    // *************** CONSTRUCTORES **********************
    public Ciudad() {
    }

    public Ciudad(String id) {
        this.id = id;
    }

    public Ciudad(String id, String nombre, Departamento departamento) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }


    // ************ ToString ***************************


    @Override
    public String toString() {
        return "Ciudad{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}
