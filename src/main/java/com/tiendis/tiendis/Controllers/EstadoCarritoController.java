package com.tiendis.tiendis.Controllers;



import com.tiendis.tiendis.entity.EstadoCarrito;
import com.tiendis.tiendis.service.EstadoCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/estcar/")
public class EstadoCarritoController {

    @Autowired
    private EstadoCarritoService estadoCarritoService;

    @GetMapping(value = "/all")
    public List<EstadoCarrito> getAll(){
        return estadoCarritoService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<EstadoCarrito> save(@RequestBody EstadoCarrito estadoCarrito){
        EstadoCarrito obj = estadoCarritoService.save(estadoCarrito);
        return new ResponseEntity<EstadoCarrito>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public EstadoCarrito find(@PathVariable Long id) {
        return estadoCarritoService.get(id);
    }

    @PostMapping(value= "/delete/{id}")
    public ResponseEntity<EstadoCarrito> delete(@PathVariable Long id) {
        EstadoCarrito estadoCarrito = estadoCarritoService.get((id));
        if (estadoCarrito != null){
            estadoCarritoService.delete(id);
        }else{
            return new ResponseEntity<EstadoCarrito>(estadoCarrito, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<EstadoCarrito>(estadoCarrito, HttpStatus.OK);
    }
}
