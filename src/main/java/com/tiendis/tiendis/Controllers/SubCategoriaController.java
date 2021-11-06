package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.entity.SubCategoria;
import com.tiendis.tiendis.service.SubCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public SubCategoria find(@PathVariable Long id) {
        return subCategoriaService.get(id);
    }

    @PostMapping(value= "/delete/{id}")
    public ResponseEntity<SubCategoria> delete(@PathVariable Long id) {
        SubCategoria subCategoria = subCategoriaService.get((id));
        if (subCategoria != null){
            subCategoriaService.delete(id);
        }else{
            return new ResponseEntity<SubCategoria>(subCategoria, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<SubCategoria>(subCategoria, HttpStatus.OK);
    }
}
