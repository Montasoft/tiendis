package com.tiendis.tiendis.entity;

import javax.persistence.*;

@Entity
@Table(name = "categori4", schema= "public")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //En postgreSQL no corria con IDENTITY.
    @Column(name = "IdCat", columnDefinition = "serial", nullable = false, unique = true )
    private long id;

    @Column(name = "nombre", length = 150)
    private String nombre;

    @Column(name = "descripcion", length = 250)
    private String descripcion;


    //@OneToMany(mappedBy = "categoria")
    //@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JsonManagedReference
    //private List<Producto> Productos = new ArrayList<>();

    // *************** CONSTRUCTORES **********************
    public Categoria() {
    }

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // ************** GETTER AND SETTER *******************

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
/*
    public List<Producto> getProductos() {
        return Productos;
    }

    public void setProductos(List<Producto> productos) {
        Productos = productos;
    }
*/

    // ************ ToString ***************************

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
               // ", Productos=" + Productos +
                '}';
    }
}
