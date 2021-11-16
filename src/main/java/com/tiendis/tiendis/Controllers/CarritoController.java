package com.tiendis.tiendis.Controllers;


import com.tiendis.tiendis.entity.Carrito;
import com.tiendis.tiendis.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value=  "api/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping(value = "/all")
    public List<Carrito> getall() {
        return carritoService.getAll();
    }

    @PostMapping(value = "save")
    public ResponseEntity<Carrito> save (@RequestBody Carrito carrito){
        Carrito obj =carritoService.save(carrito);
        return new ResponseEntity<Carrito>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public Carrito find(@PathVariable Integer id){
        return carritoService.get(id);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Carrito> delete(@PathVariable Integer id){
        Carrito carrito = carritoService.get(id);
        if (carrito != null){
            carritoService.delete(id);
        }else{
            return new ResponseEntity<Carrito>(carrito, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Carrito>(carrito, HttpStatus.OK) ;
    }

}
