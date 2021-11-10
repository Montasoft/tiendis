package com.tiendis.tiendis.entity;

import javax.persistence.*;

@Entity
@Table(name =  "prevent4", schema = "public")
public class CarritoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdCarritoDetalle", nullable = false, unique = true)
    private long id;

    @Column(name = "IdCarrito")
    private long idCarrito;

    @Column(name = "producto", length = 100)
    private Producto producto;

    @Column(name= "cantidad")
    private int cantidad;

    @Column(name = "valorUnita")
    private int valorUnita;

    @Column(name = "descuento")
    private long descuento;

    @Column(name = "observacion")
    private String observacion;

    // *******  CONSTRUCTORES ***************


}