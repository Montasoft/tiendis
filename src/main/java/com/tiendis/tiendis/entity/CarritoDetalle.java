package com.tiendis.tiendis.entity;

import javax.persistence.*;

@Entity
@Table(name =  "carritoDetalle", schema = "public")
public class CarritoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdCarritoDetalle", nullable = false, unique = true)
    private long id;

    @Column(name = "IdCarrito")
    private long idCarrito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto")
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