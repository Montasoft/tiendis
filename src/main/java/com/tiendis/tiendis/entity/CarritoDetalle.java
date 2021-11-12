package com.tiendis.tiendis.entity;

import javax.persistence.*;

@Entity
@Table(name =  "carritoDetalle", schema = "public")
public class CarritoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCarritoDetalle", columnDefinition = "serial", nullable = false, unique = true)
    private long id;

    @Column(name = "IdCarrito")
    private long idCarrito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto")
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "valorUnita")
    private long valorUnita;

    @Column(name = "descuento")
    private long descuento;

    @Column(name = "observacion")
    private String observacion;

    // *******  CONSTRUCTORES ***************


    public CarritoDetalle() {
    }

    public CarritoDetalle(long id, long idCarrito, Producto producto, int cantidad, long valorUnita, long descuento, String observacion) {
        this.id = id;
        this.idCarrito = idCarrito;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valorUnita = valorUnita;
        this.descuento = descuento;
        this.observacion = observacion;
    }

    // ************* GETTER AND SETTER ************************


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getValorUnita() {
        return valorUnita;
    }

    public void setValorUnita(long valorUnita) {
        this.valorUnita = valorUnita;
    }

    public long getDescuento() {
        return descuento;
    }

    public void setDescuento(long descuento) {
        this.descuento = descuento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    // ************  ToString ************************


    @Override
    public String toString() {
        return "CarritoDetalle{" +
                "id=" + id +
                ", idCarrito=" + idCarrito +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                ", valorUnita=" + valorUnita +
                ", descuento=" + descuento +
                ", observacion='" + observacion + '\'' +
                '}';
    }
}