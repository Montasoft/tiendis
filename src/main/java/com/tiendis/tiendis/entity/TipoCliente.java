package com.tiendis.tiendis.entity;

import javax.persistence.*;

@Entity
@Table(name = "TipoCliente", schema = "public")
public class TipoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipoCliente", columnDefinition = "serial", nullable = false, unique = true)
    private long id;

    @Column(name = "nombre", length = 50)
    private String nombre;


    /* ********** CONSTRUCTORES ************* */

    public TipoCliente() {
    }
    public TipoCliente(long id, String nombre) {
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
        return "TipoCliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}


