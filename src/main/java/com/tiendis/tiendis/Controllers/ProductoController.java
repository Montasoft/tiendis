package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.entity.Producto;
import com.tiendis.tiendis.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/prod/")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping(value = "/all")
    public List<Producto> getAll(){
        return productoService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        Producto obj = productoService.save(producto);
        return new ResponseEntity<Producto>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public Producto find(@PathVariable Integer id) {
        return productoService.get(id);
    }

    @PostMapping(value= "/delete/{id}")
    public ResponseEntity<Producto> delete(@PathVariable Integer id) {
        Producto producto = productoService.get((id));
        if (producto != null){
            productoService.delete(id);
        }else{
            return new ResponseEntity<Producto>(producto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }
}
