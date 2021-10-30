package com.tiendis.tiendis.entity;

import javax.persistence.*;

@Entity
@Table(name = "product0")
public class Producto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "IdProduct0", nullable = false, unique = true)
    private Long id;

        @Column(name = "nombre", length = 150)
    private String nombre;

        @ManyToOne
    private Categoria categoria;

        @Column (name = "subCategoria")
    private int subCategoria;
    private double Existencias;
    private int stockMin;
    private int canEmp;
    private int estado;
    private double costo;
    private double precio1;
    private double precio2;
        @Column(name = "descripcion", length = 256)
    private String descripcion;
    private int proveedor;

    public Producto() {
    }

    public Producto(String nombre, Categoria categoria, int subCategoria, double existencias, int stockMin, int canEmp, int estado, double costo, double precio1, double precio2, String descripcion, int proveedor) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        Existencias = existencias;
        this.stockMin = stockMin;
        this.canEmp = canEmp;
        this.estado = estado;
        this.costo = costo;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(int subCategoria) {
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

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

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

