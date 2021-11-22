package com.tiendis.tiendis.Controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/cat/")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/all")
    public List<Categoria> getAll(){
        return categoriaService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){
        Categoria obj = categoriaService.save(categoria);
        return new ResponseEntity<Categoria>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public Categoria find(@PathVariable Integer id) {
        return categoriaService.get(id);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Categoria categoria = categoriaService.get((id));
            if (categoria != null){
                categoriaService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }}
