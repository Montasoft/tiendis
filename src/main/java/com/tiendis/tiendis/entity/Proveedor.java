package com.tiendis.tiendis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name = "Proveed0r", schema= "public")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProveed0r", columnDefinition = "serial",  nullable = false, unique = true )
    private int id;

    @Column(name = "nombr3", length = 150)
    private String nombre;

    @Column(name = "N1t", length = 20)
    private String Nit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Ciud4d")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Ciudad ciudad;


    @Column(name = "direcci0n", length = 50)
    private String direccion;

    @Column(name = "telefon0", length = 10)
    private String telefono;

    @Column(name = "ema1l", length = 50)
    private String email;

    @Column(name = "nombreContact0", length = 50)
    private String nombreContacto;

    @Column(name = "CargoContact0", length = 50)
    private String cargoContacto;

    @Column(name = "telContact0", length = 10)
    private String telContacto;

    @Column(name = "emailContact0", length = 50)
    private String emailContacto;

    //******************  CONSTRUCTORES ***********************


    public Proveedor() {
    }

    public Proveedor(int id, String nombre, String nit, Ciudad ciudad, String direccion, String telefono, String email, String nombreContacto, String cargoContacto, String telContacto, String emailContacto) {
        this.id = id;
        this.nombre = nombre;
        Nit = nit;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.nombreContacto = nombreContacto;
        this.cargoContacto = cargoContacto;
        this.telContacto = telContacto;
        this.emailContacto = emailContacto;
    }

    // ***************** GETTERS AND SETTERS *******************

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

    public String getNit() {
        return Nit;
    }

    public void setNit(String nit) {
        Nit = nit;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getCargoContacto() {
        return cargoContacto;
    }

    public void setCargoContacto(String cargoContacto) {
        this.cargoContacto = cargoContacto;
    }

    public String getTelContacto() {
        return telContacto;
    }

    public void setTelContacto(String telContacto) {
        this.telContacto = telContacto;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }


    // **************** ToString ******************************


    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Nit='" + Nit + '\'' +
                ", ciudad=" + ciudad +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", nombreContacto='" + nombreContacto + '\'' +
                ", cargoContacto='" + cargoContacto + '\'' +
                ", telContacto='" + telContacto + '\'' +
                ", emailContacto='" + emailContacto + '\'' +
                '}';
    }
}
