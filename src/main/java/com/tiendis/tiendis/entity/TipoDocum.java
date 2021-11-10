package com.tiendis.tiendis.entity;

import javax.persistence.*;

@Entity
@Table(name = "TipoDocum", schema = "public")
public class TipoDocum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdTipoDoc", nullable = false, unique = true)
    private long id;

    @Column(name = "nombre", length = 50)
    private String nombre;


    /* ********** CONSTRUCTORES ************* */

    public TipoDocum() {
    }
    public TipoDocum(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /* ********** GETTER AND SETTER ************* */

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

    /* ********** ToString *****************  */

    @Override
    public String toString() {
        return "TipoDocum{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}


