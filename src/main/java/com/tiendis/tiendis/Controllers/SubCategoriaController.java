package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.SubCategoria;
import com.tiendis.tiendis.service.SubCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/subcat/")
public class SubCategoriaController {

    @Autowired
    private SubCategoriaService subCategoriaService;

    @GetMapping(value = "/all")
    public List<SubCategoria> getAll(){
        return subCategoriaService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<SubCategoria> save(@RequestBody SubCategoria subCategoria){
        SubCategoria obj = subCategoriaService.save(subCategoria);
        return new ResponseEntity<SubCategoria>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public SubCategoria find(@PathVariable Integer id) {
        return subCategoriaService.get(id);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            SubCategoria subCategoria = subCategoriaService.get((id));
            if (subCategoria != null){
                subCategoriaService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
