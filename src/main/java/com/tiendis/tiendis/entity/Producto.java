package com.tiendis.tiendis.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "product0", schema = "public")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProduct0", columnDefinition = "serial", nullable = false, unique = true)
    private int id;

    @Column(name = "nombre", length = 150)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoriaId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategoriaId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private SubCategoria subCategoria;

    @Column(name = "Existencias")
    private double Existencias;

    @Column(name = "stockMin")
    private int stockMin;

    @Column(name = "canEmp")
    private int canEmp;

    @Column(name = "estado")
    private int estado;

    @Column(name = "costo")
    private double costo;

    @Column(name = "precio1")
    private double precio1;

    @Column(name = "precio2")
    private double precio2;

    @Column(name = "descripcion", length = 256)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Proveedor proveedor;

    // *********** CONSTRUCTORES *****************

    public Producto() {
    }

    public Producto(String nombre, Categoria categoria, SubCategoria subCategoria, double existencias, int stockMin, int canEmp, int estado, double costo, double precio1, double precio2, String descripcion, Proveedor proveedor) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.Existencias = existencias;
        this.stockMin = stockMin;
        this.canEmp = canEmp;
        this.estado = estado;
        this.costo = costo;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    // *************** GETTERS AND SETTERS ***************

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public SubCategoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
    }

    public double getExistencias() {
        return Existencias;
    }

    public void setExistencias(double existencias) {
        Existencias = existencias;
    }

    public int getStockMin() {
        return stockMin;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    public int getCanEmp() {
        return canEmp;
    }

    public void setCanEmp(int canEmp) {
        this.canEmp = canEmp;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio1() {
        return precio1;
    }

    public void setPrecio1(double precio1) {
        this.precio1 = precio1;
    }

    public double getPrecio2() {
        return precio2;
    }

    public void setPrecio2(double precio2) {
        this.precio2 = precio2;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }


    // ************* ToString ******************

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", subCategoria=" + subCategoria +
                ", Existencias=" + Existencias +
                ", stockMin=" + stockMin +
                ", canEmp=" + canEmp +
                ", estado=" + estado +
                ", costo=" + costo +
                ", precio1=" + precio1 +
                ", precio2=" + precio2 +
                ", descripcion='" + descripcion + '\'' +
                ", proveedor=" + proveedor +
                '}';
    }
}

