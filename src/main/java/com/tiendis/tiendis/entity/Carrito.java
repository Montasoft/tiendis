package com.tiendis.tiendis.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.ClientInfoStatus;
import java.util.Date;

@Entity
@Table(name =  "carrit0", schema = "public")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCarrito", columnDefinition = "serial", nullable = false, unique = true)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @Column(name = "fechaCarrito", length = 19)
  //  @Temporal(TemporalType.DATE)
  //  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String fechaCarrito;

    @Column(name="valor")
    private long valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formaPago")
    private FormaPago formapago;

    @Column(name= "Nota", length = 256)
    private String nota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "estado")
    private EstadoCarrito estadoCarrito;

    // *******  CONSTRUCTORES ***************


    public Carrito() {
    }

    public Carrito(int id, Cliente cliente, String fechaCarrito, long valor, FormaPago formapago, String nota, EstadoCarrito estadoCarrito) {
        this.id = id;
        this.cliente = cliente;
        this.fechaCarrito = fechaCarrito;
        this.valor = valor;
        this.formapago = formapago;
        this.nota = nota;
        this.estadoCarrito = estadoCarrito;
    }

    // ************ GETTER AND SETTER *******************


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFechaCarrito() {
        return fechaCarrito;
    }

    public void setFechaCarrito(String fechaCarrito) {
        this.fechaCarrito = fechaCarrito;
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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
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
                ", fechaCarrito='" + fechaCarrito + '\'' +
                ", valor=" + valor +
                ", formapago=" + formapago +
                ", nota=" + nota +
                ", estadoCarrito=" + estadoCarrito +
                '}';
    }
}
