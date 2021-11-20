package com.tiendis.tiendis.Controllers;


import com.tiendis.tiendis.entity.Carrito;
import com.tiendis.tiendis.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Map<String, Object> map = new HashMap<>();
        Carrito carrito = carritoService.get(id);
        if (carrito != null){
            carritoService.delete(id);
        }else{
            map.put("Error", "No existe registro con el id indicado");
            return new ResponseEntity<String>(map.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("success", "\"Registro eliminado con éxito\"" );
        return new ResponseEntity<String>(map.toString(), HttpStatus.OK) ;
    }

}
