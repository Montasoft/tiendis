package com.tiendis.tiendis.Controllers;

import com.tiendis.tiendis.commons.ResponseHandler;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.TipoComercio;
import com.tiendis.tiendis.service.TipoComercioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/tcomer/")
public class TipoComercioController {

    @Autowired
    private TipoComercioService tipoComercioService;

    @GetMapping(value = "/all")
    public List<TipoComercio> getAll(){
        return tipoComercioService.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<TipoComercio> save(@RequestBody TipoComercio tipoComercio){
        TipoComercio obj = tipoComercioService.save(tipoComercio);
        return new ResponseEntity<TipoComercio>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}")
    public TipoComercio find(@PathVariable Integer id) {
        return tipoComercioService.get(id);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            TipoComercio tipoComercio = tipoComercioService.get((id));
            if (tipoComercio != null){
                tipoComercioService.delete(id);
            }else {
                return ResponseHandler.generateResponse("No existe registro con el id indicado", HttpStatus.OK, null);
            }
            return ResponseHandler.generateResponse("Registro Eliminado con éxito", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
