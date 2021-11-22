package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.Producto;
import com.tiendis.tiendis.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Producto producto = productoService.get((id));
            if (producto != null){
                productoService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
