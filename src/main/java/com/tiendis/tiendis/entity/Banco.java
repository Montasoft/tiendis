package com.tiendis.tiendis.entity;


import javax.persistence.*;

@Entity
@Table(name = "Banc0", schema= "public")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //En postgreSQL no corria con IDENTITY.
    @Column(name = "IdBanco", nullable = false, unique = true )
    private long id;

    @Column(name = "nombre", length = 150)
    private String nombre;


    public Banco() {
    }

    public Banco(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
