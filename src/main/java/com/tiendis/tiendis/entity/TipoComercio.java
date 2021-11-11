package com.tiendis.tiendis.entity;

import javax.persistence.*;

@Entity
@Table(name = "TipoComercio", schema = "public")
public class TipoComercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipoComercio", columnDefinition = "serial", nullable = false, unique = true)
    private long id;

    @Column(name = "nombre", length = 50)
    private String nombre;


    /* ********** CONSTRUCTORES ************* */

    public TipoComercio() {
    }
    public TipoComercio(long id, String nombre) {
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
        return "TipoComercio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}


