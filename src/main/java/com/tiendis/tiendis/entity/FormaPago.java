package com.tiendis.tiendis.entity;

import javax.persistence.*;

@Entity
@Table(name = "FormaPago", schema = "public")
public class FormaPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdFormaPago", columnDefinition = "serial", nullable = false, unique = true)
    private int id;

    @Column(name = "nombre", length = 50)
    private String nombre;


    /* ********** CONSTRUCTORES ************* */

    public FormaPago() {
    }
    public FormaPago(int id, String nombre) {
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
        return "FormaPago{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}


