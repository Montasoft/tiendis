package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.Ciudad;
import com.tiendis.tiendis.service.CategoriaService;
import com.tiendis.tiendis.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Ciudad> delete(@PathVariable String id) {
        Ciudad ciudad = ciudadService.get((id));
        if (ciudad != null){
            ciudadService.delete(id);
        }else{
            return new ResponseEntity<Ciudad>(ciudad, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Ciudad>(ciudad, HttpStatus.OK);
    }
}
