package com.tiendis.tiendis.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subcategori4", schema= "public")
public class SubCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdSubCat", columnDefinition = "serial", nullable = false, unique = true )
    private int id;

    @Column(name = "nombre", length = 150)
    private String nombre;

   // @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "categoriaIdCat")
    private Categoria categoria;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    /*
    @OneToMany(mappedBy = "subCategoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   // @JsonManagedReference
    private List<Producto> Productos = new ArrayList<>();
*/

    // *******  CONSTRUCTORES ***************
    public SubCategoria() {
    }

    public SubCategoria(String nombre, Categoria categoria, String descripcion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public SubCategoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /*
    public List<Producto> getProductos() {
        return Productos;
    }

    public void setProductos(List<Producto> productos) {
        Productos = productos;
    }
*/

    // ************* ToString *********************

    @Override
    public String toString() {
        return "SubCategoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
