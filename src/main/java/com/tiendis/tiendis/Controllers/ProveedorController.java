package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.entity.Proveedor;
import com.tiendis.tiendis.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



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

    @PostMapping(value= "/delete/{id}")
    public ResponseEntity<Proveedor> delete(@PathVariable Integer id) {
        Proveedor proveedor = proveedorService.get((id));
        if (proveedor != null){
            proveedorService.delete(id);
        }else{
            return new ResponseEntity<Proveedor>(proveedor, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
    }
}
