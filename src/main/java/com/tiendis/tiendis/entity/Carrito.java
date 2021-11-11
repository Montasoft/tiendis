package com.tiendis.tiendis.entity;

import javax.persistence.*;
import java.sql.ClientInfoStatus;
import java.util.Date;

@Entity
@Table(name =  "carrit0", schema = "public")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdCarrito", nullable = false, unique = true)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @Column(name = "fechaCarrito")
    private Date fechaPrev;

    @Column(name="valor")
    private long valor;

    @Column(name = "formaPago")
    private long formpago;

    @Column(name= "Nota", length = 256)
    private long nota;

    @Column(name= "estado")
    private long estado;

}
