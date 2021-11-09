package com.tiendis.tiendis.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "CuentaBancariaProv", schema = "public")
public class CuentaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCuent4", nullable = false, unique = true)
    private long id;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "proveedor")
    private Proveedor proveedor;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="TipoCuent4")
    private TipoCuenta tipoCuenta;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "banc0")
    private Banco banco;

    @Column(name= "NumCuenta")
    private int numCuenta;

    @Column(name= "Not4")
    private String nota;


    public CuentaBancaria() {
    }

    public CuentaBancaria(long id, TipoCuenta tipoCuenta, Banco banco, int numCuenta, String nota) {
        this.id = id;
        this.tipoCuenta = tipoCuenta;
        this.banco = banco;
        this.numCuenta = numCuenta;
        this.nota = nota;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

  /*  public long getProveedorId() {
        return proveedor.getId();
    }*/

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    /*public Long getTipoCuentaId() {
        return tipoCuenta.getId();
    }*/

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Banco getBanco() {
        return banco;
    }
  /*  public Long getBancoId() {
        return banco.getId();
    }*/

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "id=" + id +
                ", proveedor=" + proveedor +
                ", tipoCuenta=" + tipoCuenta +
                ", banco=" + banco +
                ", numCuenta=" + numCuenta +
                ", nota='" + nota + '\'' +
                '}';
    }
}
