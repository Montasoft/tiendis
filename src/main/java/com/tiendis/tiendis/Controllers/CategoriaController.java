package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.Repository.CategoriaRepository;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Categoria> delete(@PathVariable Integer id) {
        Categoria categoria = categoriaService.get((id));
        if (categoria != null){
            categoriaService.delete(id);
        }else{
            return new ResponseEntity<Categoria>(categoria, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
    }
}
