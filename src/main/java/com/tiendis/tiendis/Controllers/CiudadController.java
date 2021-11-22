package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.Ciudad;
import com.tiendis.tiendis.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/ciudad/")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @GetMapping(value = "/all")
    public List<Ciudad> getAll(){
        return ciudadService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Ciudad> save(@RequestBody Ciudad ciudad){
        Ciudad obj = ciudadService.save(ciudad);
        return new ResponseEntity<Ciudad>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public Ciudad find(@PathVariable String id) {
        return ciudadService.get(id);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        try {
            Ciudad ciudad = ciudadService.get((id));
            if (ciudad != null){
                ciudadService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }}
