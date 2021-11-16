package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.entity.TipoDocum;
import com.tiendis.tiendis.service.TipoDocumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tdocum/")
public class TipoDocumController {

    @Autowired
    private TipoDocumService tipoDocumService;

    @GetMapping(value = "/all")
    public List<TipoDocum> getAll(){
        return tipoDocumService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<TipoDocum> save(@RequestBody TipoDocum tipoDocum){
        TipoDocum obj = tipoDocumService.save(tipoDocum);
        return new ResponseEntity<TipoDocum>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public TipoDocum find(@PathVariable Integer id) {
        return tipoDocumService.get(id);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<TipoDocum> delete(@PathVariable Integer id) {
        TipoDocum tipoDocum = tipoDocumService.get((id));
        if (tipoDocum != null){
            tipoDocumService.delete(id);
        }else{
            return new ResponseEntity<TipoDocum>(tipoDocum, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<TipoDocum>(tipoDocum, HttpStatus.OK);
    }
}
