package com.tiendis.tiendis.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Banc0", schema= "public")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //En postgreSQL no corria con IDENTITY.
    @Column(name = "IdBanco", columnDefinition = "serial", nullable = false, unique = true )
    private int id;

    @Column(name = "nombre", length = 150)
    private String nombre;

    @OneToMany(mappedBy = "banco")
    //@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<CuentaBancaria> cuentaBancariaset;

    public Banco() {
    }

    public Banco(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
