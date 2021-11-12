package com.tiendis.tiendis.entity;

import javax.persistence.*;
import java.sql.ClientInfoStatus;
import java.util.Date;

@Entity
@Table(name =  "carrit0", schema = "public")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCarrito", columnDefinition = "serial", nullable = false, unique = true)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @Column(name = "fechaCarrito", length = 19)
    private String fechaPrev;

    @Column(name="valor")
    private long valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formaPago")
    private FormaPago formapago;

    @Column(name= "Nota", length = 256)
    private long nota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "estado")
    private EstadoCarrito estadoCarrito;

    // *******  CONSTRUCTORES ***************


    public Carrito() {
    }

    public Carrito(long id, Cliente cliente, String fechaPrev, long valor, FormaPago formapago, long nota, EstadoCarrito estadoCarrito) {
        this.id = id;
        this.cliente = cliente;
        this.fechaPrev = fechaPrev;
        this.valor = valor;
        this.formapago = formapago;
        this.nota = nota;
        this.estadoCarrito = estadoCarrito;
    }

    // ************ GETTER AND SETTER *******************


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFechaPrev() {
        return fechaPrev;
    }

    public void setFechaPrev(String fechaPrev) {
        this.fechaPrev = fechaPrev;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public FormaPago getFormapago() {
        return formapago;
    }

    public void setFormapago(FormaPago formapago) {
        this.formapago = formapago;
    }

    public long getNota() {
        return nota;
    }

    public void setNota(long nota) {
        this.nota = nota;
    }

    public EstadoCarrito getEstadoCarrito() {
        return estadoCarrito;
    }

    public void setEstadoCarrito(EstadoCarrito estadoCarrito) {
        this.estadoCarrito = estadoCarrito;
    }

    // ************* ToString ************************


    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", fechaPrev='" + fechaPrev + '\'' +
                ", valor=" + valor +
                ", formapago=" + formapago +
                ", nota=" + nota +
                ", estadoCarrito=" + estadoCarrito +
                '}';
    }
}
