package com.tiendis.tiendis.entity;

import javax.persistence.*;

@Entity
@Table(name = "TipoCliente", schema = "public")
public class TipoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipoCliente", columnDefinition = "serial", nullable = false, unique = true)
    private int id;

    @Column(name = "nombre", length = 50)
    private String nombre;


    /* ********** CONSTRUCTORES ************* */

    public TipoCliente() {
    }
    public TipoCliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /* ********** GETTER AND SETTER ************* */

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

    /* ********** ToString *****************  */

    @Override
    public String toString() {
        return "TipoCliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}


