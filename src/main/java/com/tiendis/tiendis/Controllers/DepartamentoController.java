package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.Ciudad;
import com.tiendis.tiendis.entity.Departamento;
import com.tiendis.tiendis.service.CiudadService;
import com.tiendis.tiendis.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/departamento/")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping(value = "/all")
    public List<Departamento> getAll(){
        return departamentoService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Departamento> save(@RequestBody Departamento departamento){
        Departamento obj = departamentoService.save(departamento);
        return new ResponseEntity<Departamento>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public Departamento find(@PathVariable String id) {
        return departamentoService.get(id);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        try {
            Departamento departamento = departamentoService.get((id));
            if (departamento != null){
                departamentoService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }}
