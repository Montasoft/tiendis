package com.tiendis.tiendis.entity;

import javax.persistence.*;

@Entity
@Table(name = "Cliente", schema = "public")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCliente", columnDefinition = "serial", nullable = false, unique = true)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "birthday", length = 10)
    private String birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name= "tipoDoc")
    private TipoDocum tipoDocum;

    @Column (name= "numDoc", length = 20)
    private String numDoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ciudad")
    private Ciudad ciudad;

    @Column(name= "direccion", length = 250)
    private String direccion;

    @Column (name= "barrio", length = 150)
    private String barrio;

    @Column (name= "ubicacionGPS", length = 100)
    private String ubicacionGPS;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name= "tipoCliente")
    private TipoCliente tipoCliente;

    @Column (name= "telefono", length = 10)
    private String telefono;

    @Column (name= "whatsApp", length = 10)
    private String whatsApp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name= "tipoComercio")
    private TipoComercio tipoComercio;

    @Column (name= "nomComercio", length = 150)
    private String nomComercio;

    @Column (name= "dirComercio", length = 100)
    private String dirComercio;


    // ********* CONSTRUCTURES **********************

    public Cliente() {
    }

    // CONSTRUCTOR SIN DATOS DEL COMERCIO //
    public Cliente(int id, String nombre, String birthday, TipoDocum tipoDocum, String numDoc, Ciudad ciudad, String direccion, String barrio, String ubicacionGPS, TipoCliente tipoCliente, String telefono, String whatsApp) {
        this.id = id;
        this.nombre = nombre;
        this.birthday = birthday;
        this.tipoDocum = tipoDocum;
        this.numDoc = numDoc;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.barrio = barrio;
        this.ubicacionGPS = ubicacionGPS;
        this.tipoCliente = tipoCliente;
        this.telefono = telefono;
        this.whatsApp = whatsApp;
    }

    // CONSTRUCTOR CON DATOS DEL COMERCIO //
    public Cliente(int id, String nombre, String birthday, TipoDocum tipoDocum, String numDoc, Ciudad ciudad, String direccion, String barrio, String ubicacionGPS, TipoCliente tipoCliente, String telefono, String whatsApp, TipoComercio tipoComercio, String nomComercio, String dirComercio) {
        this.id = id;
        this.nombre = nombre;
        this.birthday = birthday;
        this.tipoDocum = tipoDocum;
        this.numDoc = numDoc;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.barrio = barrio;
        this.ubicacionGPS = ubicacionGPS;
        this.tipoCliente = tipoCliente;
        this.telefono = telefono;
        this.whatsApp = whatsApp;
        this.tipoComercio = tipoComercio;
        this.nomComercio = nomComercio;
        this.dirComercio = dirComercio;
    }

    // *************   GETTER AND SETTER **************

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public TipoDocum getTipoDocum() {
        return tipoDocum;
    }

    public void setTipoDocum(TipoDocum tipoDocum) {
        this.tipoDocum = tipoDocum;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getUbicacionGPS() {
        return ubicacionGPS;
    }

    public void setUbicacionGPS(String ubicacionGPS) {
        this.ubicacionGPS = ubicacionGPS;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public TipoComercio getTipoComercio() {
        return tipoComercio;
    }

    public void setTipoComercio(TipoComercio tipoComercio) {
        this.tipoComercio = tipoComercio;
    }

    public String getNomComercio() {
        return nomComercio;
    }

    public void setNomComercio(String nomComercio) {
        this.nomComercio = nomComercio;
    }

    public String getDirComercio() {
        return dirComercio;
    }

    public void setDirComercio(String dirComercio) {
        this.dirComercio = dirComercio;
    }

    // ************* ToString ******************


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", birthday='" + birthday + '\'' +
                ", tipoDocum=" + tipoDocum +
                ", numDoc='" + numDoc + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", barrio='" + barrio + '\'' +
                ", ubicacionGPS='" + ubicacionGPS + '\'' +
                ", tipoCliente=" + tipoCliente +
                ", telefono='" + telefono + '\'' +
                ", whatsApp='" + whatsApp + '\'' +
                ", tipoComercio=" + tipoComercio +
                ", nomComercio='" + nomComercio + '\'' +
                ", dirComercio='" + dirComercio + '\'' +
                '}';
    }
}
