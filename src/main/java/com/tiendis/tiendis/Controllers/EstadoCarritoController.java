package com.tiendis.tiendis.Controllers;



import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.EstadoCarrito;
import com.tiendis.tiendis.service.EstadoCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public EstadoCarrito find(@PathVariable Integer id) {
        return estadoCarritoService.get(id);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            EstadoCarrito estadoCarrito = estadoCarritoService.get((id));
            if (estadoCarrito != null){
                estadoCarritoService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }}
