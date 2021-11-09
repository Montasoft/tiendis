package com.tiendis.tiendis.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name =  "prevent4", schema = "public")
public class Preventa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdPreventa", nullable = false, unique = true)
    private long id;

    @Column(name = "cliente", length = 100)
    private String cliente;

    @Column(name = "fechaPrev")
    private Date fechaPrev;
    


}
