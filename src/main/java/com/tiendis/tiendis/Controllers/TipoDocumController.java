package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.TipoCuenta;
import com.tiendis.tiendis.entity.TipoDocum;
import com.tiendis.tiendis.service.TipoDocumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            TipoDocum tipoDocum = tipoDocumService.get((id));
            if (tipoDocum != null){
                tipoDocumService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
