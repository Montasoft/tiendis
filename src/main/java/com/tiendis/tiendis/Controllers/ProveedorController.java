package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.Proveedor;
import com.tiendis.tiendis.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/prove/")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping(value = "/all")
    public List<Proveedor> getAll(){
        return proveedorService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Proveedor> save(@RequestBody Proveedor proveedor){
        Proveedor obj = proveedorService.save(proveedor);
        return new ResponseEntity<Proveedor>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public Proveedor find(@PathVariable Integer id) {
        return proveedorService.get(id);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Proveedor proveedor = proveedorService.get((id));
            if (proveedor != null){
                proveedorService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
